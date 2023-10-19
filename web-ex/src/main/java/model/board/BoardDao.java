package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import model.user.User;
import model.user.UserRequestDto;
import util.DBmanager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BoardDao() {}
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public boolean createBoard(BoardRequestDto user) {
		
		Board board = new Board(user);
		
		conn = DBmanager.getConnection();
		
		String sql = "INSERT INTO web_board(user_id,title,contents,in_date) VALUES(?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getId());
			pstmt.setString(2,board.getTitle());
			pstmt.setString(3,board.getContents());
			
			
			int result = pstmt.executeUpdate();
	        if (result > 0) {
	            return true;
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBmanager.close(conn, pstmt);
		}
		
		return false;
	}

	public ArrayList<BoardResponseDto> findAll() {
		ArrayList<BoardResponseDto> respons = new ArrayList<>();
		conn = DBmanager.getConnection();
		if(conn != null) {
			String sql = "SELECT b.id, b.user_id, b.title, b.contents, TO_CHAR(in_date,'YYYYMMDD HH24:MI') in_date, TO_CHAR(up_date,'YYYYMMDD HH24:MI') up_date, u.name "
                    + "FROM web_board b "
                    + "JOIN web_user u ON b.user_id = u.id";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt(1);
					int user_id = rs.getInt(2);
					String title = rs.getString(3);
					String contents = rs.getString(4);
					String in_date = rs.getString(5);
					String up_date = rs.getString(6);
					String name = rs.getString(7);
					
					respons.add(new BoardResponseDto(new Board(id,user_id,title,contents,in_date,up_date,name)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return respons;
	}
	
	public boolean setUser(BoardRequestDto board) {
		
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "UPDATE web_board SET title = ?,contents = ?,up_date = sysdate where id = ?";
			try {
				pstmt = conn.prepareStatement(sql);
		
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getContents());
				pstmt.setInt(3, board.getId());
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBmanager.close(conn, pstmt);
			}
		}
		
		return true;
	}
	
	public boolean deleteBoard(BoardRequestDto board) {
		conn = DBmanager.getConnection();
		
		if(conn != null) {
			String sql = "DELETE from web_board where id = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, board.getId());
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				
			}finally{
				DBmanager.close(conn, pstmt);
			}
		}
		
		return true;
	}
	
	
	
	
}
