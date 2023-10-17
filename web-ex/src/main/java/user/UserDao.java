package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.cj.xdevapi.Result;

import util.DBmanager;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private UserDao() {}
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	public boolean createUser(UserRequestDto user) {
		if(isDuplicatedUser(user)) {
			return false;
		}
		User newUser = new User(user);
		newUser.setId(generateId());
		
		//conn = DBmanager.getConnection(); 앞에서 선언 후 finally가 안되있으므로 선언할 필요가 없다
		//초기화만 시켜준다
		
			String sql = "INSERT INTO `USER` VALUES(?,?,?,?,date(?),?,?,?)";
			
			int genterStr;
			if(newUser.getGender()  == "male") {
				genterStr = 1;
			}else {
				genterStr = 2;
			}
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, newUser.getId());
				pstmt.setString(2, newUser.getUsername());
				pstmt.setString(3, newUser.getPassword());
				pstmt.setString(4, newUser.getName());
				pstmt.setString(5, newUser.getBirth());
				pstmt.setInt(6, genterStr);
				pstmt.setString(7, newUser.getTel());
				pstmt.setString(8, newUser.getPnum());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBmanager.close(conn, pstmt);
			}
		
		
		
		return true;
	}
	
	public boolean isDuplicatedUser(UserRequestDto user) {
		String sql = "select * from `USER` where userbname = ?";
		
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUsername());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
//	public boolean duplicatedUser(UserRequestDto user) {
//		for(int i=0; i<list.size(); i++) {
//			if(user.getUsername().equals((list).get(i).getUsername()) && user.getPassword().equals((list).get(i).getPassword())) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
	public boolean passwoerUser(UserRequestDto user) {
		boolean result = false;
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "select * from `USER` where password = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getPassword());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	private int generateId() {
		int id = 0;
		boolean idDupl = true;
		if(idDupl == true) {
			
			id =(int) Math.floor(Math.random() * (9999-1000+1))+1000; // 1000~9999 랜덤
			
			conn = DBmanager.getConnection();
			
			if(conn != null) {
				String sql = "select * from `USER` where id = ?";
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, id);
					
					rs = pstmt.executeQuery();
					
					if(rs.next()) {
						idDupl = false;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
		
		return id;
	}
	
	public UserResponseDto findById(int id) {
		UserResponseDto result =null;
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "select * from `USER` where id = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String username = rs.getString(2);
					String password = rs.getString(3);
					String name = rs.getString(4);
					String birth = rs.getString(5);
					int gender = rs.getInt(6);
					String tel = rs.getString(7);
					String pnum = rs.getString(8);
					
					String genterStr = "";
					if(gender  == 1) {
						genterStr ="male";
					}else {
						genterStr = "female";
					}
					
					result =new UserResponseDto(new User(id,username,password,name,birth,genterStr,tel,pnum));
					System.out.println("result : "+result);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBmanager.close(conn, pstmt, rs);
			}
		}
		
		return result;
	}
	
	public UserResponseDto findByUsername(String username,String password) {
		UserResponseDto result =null;
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "select * from `USER` where username = ? AND `password` = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(4);
					String birth = rs.getString(5);
					int gender = rs.getInt(6);
					String tel = rs.getString(7);
					String pnum = rs.getString(8);
					
					String genterStr = "";
					if(gender  == 1) {
						genterStr ="male";
					}else {
						genterStr = "female";
					}
					
					result =new UserResponseDto(new User(id,username,password,name,birth,genterStr,tel,pnum));
					System.out.println("result : "+result);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBmanager.close(conn, pstmt, rs);
			}
		}
		
		return result;
	}
	
	private User getUser(UserRequestDto userDto) {
		User user = null;
		
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "select * from `USER` where username = ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userDto.getUsername());
				
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int id = rs.getInt(1);
					String username = userDto.getUsername();
					String password = rs.getString(3);
					String name = rs.getString(4);
					String birth = rs.getString(5);
					int gender = rs.getInt(6);
					String tel = rs.getString(7);
					String pnum = rs.getString(8);
					
					String genterStr = "";
					if(gender  == 1) {
						genterStr ="male";
					}else {
						genterStr = "female";
					}
					user = new User(id,username,password,name,birth,genterStr,tel,pnum);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBmanager.close(conn, pstmt, rs);
			}
		}
		
		return user;
	}
	
	public ArrayList<UserResponseDto> findAll() {
		ArrayList<UserResponseDto> respons = new ArrayList<>();
		conn = DBmanager.getConnection();
		if(conn != null) {
			String sql = "select * from `USER`";
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String username = rs.getString(2);
					String password = rs.getString(3);
					String name = rs.getString(4);
					String birth = rs.getString(5);
					int gender = rs.getInt(6);
					String tel = rs.getString(7);
					String pnum = rs.getString(8);
					
					String genterStr = "";
					if(gender  == 1) {
						genterStr ="male";
					}else {
						genterStr = "female";
					}
					respons.add(new UserResponseDto(new User(username,password,name,birth,genterStr,tel,pnum)));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBmanager.close(conn, pstmt);
			}
		}
		return respons;
	}
	
	public boolean setUser(UserRequestDto user) {
		User target = getUser(user);
		
		if(target == null) {
			return false;
		}
		
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "UPDATE `USER` SET password = ?,name = ?, tel = ?, pnum = ? WHERE username = ?";
					
			try {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getTel());
				pstmt.setString(4, user.getPnum());
				pstmt.setString(5, user.getUsername());
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBmanager.close(conn, pstmt);
			}
		}
		
		
		return true;
	}
	
	public boolean delsetUser(UserRequestDto user) {
		System.out.println("user : "+user.getUsername());
		
		User target = getUser(user);
		
		if(target == null) {
			return false;
		}
		
		if(!target.getPassword().equals(user.getPassword())) {
			return false;
		}
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "DELETE from `USER` where username = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUsername());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				
			}finally{
				DBmanager.close(conn, pstmt);
			}
		}
		
		return true;
	}
	
}
