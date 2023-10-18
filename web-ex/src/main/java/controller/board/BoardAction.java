package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.board.BoardDao;
import model.board.BoardResponseDto;

public class BoardAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao boardDao = BoardDao.getInstance();
		
		ArrayList<BoardResponseDto> responseBoard = boardDao.findAll();
		
		String url ="";
		
		if(responseBoard != null) {
			HttpSession session = request.getSession();
			session.setAttribute("boardList",responseBoard);
			url = "/board";
		}else {
			url = "/";
		}
		
		response.sendRedirect(url);
	}

}
