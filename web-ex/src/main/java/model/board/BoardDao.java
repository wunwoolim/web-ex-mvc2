package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		
		String sql = "INSERT INTO board(user_id,title,contents,in_date) VALUES(?,?,?,date(sysdate()))";
		
		return true;
	}
}
