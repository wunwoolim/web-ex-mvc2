package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.board.BoardDao;
import model.board.BoardRequestDto;
import model.user.UserRequestDto;

public class BoardUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDao boardDao = BoardDao.getInstance();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		BoardRequestDto BoardCheck = new BoardRequestDto(id,title,contents);
	    boolean update = boardDao.setUser(BoardCheck);
	    
	    if(update) {
	    	response.sendRedirect("/board");
	    }else {
	    	response.sendRedirect("/boardUpdate?id="+id);
	    }

	}

}
