package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.user.UserDao;
import model.user.UserRequestDto;

public class editUserAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
		
		String username =	request.getParameter("username");
		String userpassword =	request.getParameter("userpasswordUp");
		String name =	request.getParameter("name");
		String birth =	request.getParameter("birth");
		String gender =	request.getParameter("gender");
		String tel =	request.getParameter("tel");
		String pnum =	request.getParameter("pnum");
		UserRequestDto userCheck = new UserRequestDto(username,userpassword,name,birth,gender,tel,pnum);
	    boolean update = userDao.setUser(userCheck);
	    
	   
	    
	    session.setAttribute("update", update);
	    session.setAttribute("userCheck", userCheck);
	   	
		response.sendRedirect("/Service?command=logout");
		
	}

}
