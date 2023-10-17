package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.user.UserDao;
import model.user.UserRequestDto;

public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =	request.getParameter("username");
		String userpassword =	request.getParameter("userpassword");
		String name =	request.getParameter("name");
		String birth =	request.getParameter("birth");
		String gender =	request.getParameter("gender");
		String tel =	request.getParameter("tel");
		String pnum =	request.getParameter("pnum");
		
		UserDao userDao = UserDao.getInstance();
		UserRequestDto user = new UserRequestDto(username,userpassword,name,birth,gender,tel,pnum);
		
		boolean result = userDao.createUser(user);
		
		if(result){
			response.sendRedirect("/login");
		}else{
			response.sendRedirect("/join");
		}
		
	}

}
