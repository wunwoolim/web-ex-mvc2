package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	

//	public int getSize() {
//		return list.size();
//	}
//	
//	public boolean createUser(UserRequestDto user) {
//		if(isDuplicatedUser(user)) {
//			return false;
//		}
//		User newUser = new User(user);
//		newUser.setId(generateId());
//		list.add(newUser);
//		return true;
//	}
//	
//	public boolean isDuplicatedUser(UserRequestDto user) {
//		for(int i=0; i<list.size(); i++) {
//			if(user.getUsername().equals((list).get(i).getUsername())) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
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
//	public boolean passwoerUser(UserRequestDto user) {
//		for(int i=0; i<list.size(); i++) {
//			if(user.getPassword().equals((list).get(i).getPassword())) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
//	private int generateId() {
//		int id = 0;
//		boolean idDupl = false;
//		do {
//			id =(int) Math.floor(Math.random() * (9999-1000+1))+1000; // 1000~9999 랜덤
//			
//			
//			for(int i=0; i<list.size(); i++) {
//				if(list.get(i).getId() == id){
//					idDupl = true;
//				}
//			}
//		}while(idDupl);
//		
//		return id;
//	}
	
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
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public UserResponseDto findByUsername(String username) {
		
		
		return null;
	}
//	
//	private User getUser(UserRequestDto userDto) {
//		User user = null;
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getUsername().equals(userDto.getUsername())) {
//				user = list.get(i);
//			}
//		}
//		return user;
//	}
//	
//	public ArrayList<UserResponseDto> findAll() {
//		ArrayList<UserResponseDto> respons = new ArrayList<>();
//		
//		for(int i=0; i<list.size(); i++) {
//			User user = list.get(i);
//			respons.add(new UserResponseDto(user));
//		}
//		return respons;
//	}
//	
//	public boolean setUser(UserRequestDto user) {
//		User target = getUser(user);
//		
//		if(target == null) {
//			return false;
//		}
//		target.setUsername(user.getUsername());
//		target.setPassword(user.getPassword());
//		target.setName(user.getName());
//		target.setBirth(user.getBirth());
//		target.setGender(user.getGender());
//		target.setTel(user.getTel());
//		target.setPnum(user.getPnum());
//		
//		return true;
//	}
//	
//	public boolean delsetUser(UserRequestDto user) {
//		System.out.println("user : "+user.getUsername());
//		
//		User target = getUser(user);
//		
//		if(target == null) {
//			return false;
//		}
//		
//		if(!target.getPassword().equals(user.getPassword())) {
//			return false;
//		}
//		
//		list.remove(target);
//		
//		return true;
//	}
//	
}
