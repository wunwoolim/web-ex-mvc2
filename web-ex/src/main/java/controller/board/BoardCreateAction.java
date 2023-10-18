package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.board.BoardDao;
import model.board.BoardRequestDto;

public class BoardCreateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title =	request.getParameter("title");
		String content =	request.getParameter("content");
		int id = Integer.parseInt(request.getParameter("id"));
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto board = new BoardRequestDto(id,title,content);
		
		boolean result = boardDao.createBoard(board);
		
		if(result) {
			response.sendRedirect("/Service?command=board");
		}else {
			response.sendRedirect("/boardCreate");
		}
	}

}
