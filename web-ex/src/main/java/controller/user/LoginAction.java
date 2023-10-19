package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.user.UserDao;
import model.user.UserResponseDto;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username =	request.getParameter("username");
		String password =	request.getParameter("userpassword");
		
		UserDao userDao = UserDao.getInstance();
		
		UserResponseDto responseUser = userDao.findByUsername(username,password);
		
		String url ="";
		
		if(responseUser != null){
			HttpSession session = request.getSession();
			session.setAttribute("responseUser", responseUser);
			url ="/";
			
		}else {
			url="/login";
		}
		
		response.sendRedirect(url);
		
	}
	
}
