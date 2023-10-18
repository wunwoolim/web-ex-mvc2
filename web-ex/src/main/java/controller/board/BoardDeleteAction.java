package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.board.BoardDao;
import model.board.BoardRequestDto;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = BoardDao.getInstance();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BoardRequestDto boardCheck = new BoardRequestDto(id);
		
		boolean delete = boardDao.deleteBoard(boardCheck);
		
		if(delete) {
			response.sendRedirect("/board");
		}else {
			response.sendRedirect("/boardDelete?id="+id);
		}
		
	}

}
