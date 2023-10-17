package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.user.UserDao;
import model.user.UserRequestDto;

public class leaveAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
		
		String username =	request.getParameter("username");
		String userpassword =	request.getParameter("userpasswordDel");
		
		
		UserRequestDto userCheck = new UserRequestDto(username,userpassword);
		boolean deldate = userDao.delsetUser(userCheck);
		
		if(deldate) {
			request.getSession().invalidate();
		}
		
		response.sendRedirect("/logout");
		
	}

}
