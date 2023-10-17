package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.user.UserDao;
import model.user.UserRequestDto;

public class MypageAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
	
	
		String userpassword =	request.getParameter("userpassword");
		UserRequestDto userCheck = new UserRequestDto(userpassword);
		boolean result = userDao.passwoerUser(userCheck);
		
		session.setAttribute("result", result);
		response.sendRedirect("/mypage");
		
	}

}
