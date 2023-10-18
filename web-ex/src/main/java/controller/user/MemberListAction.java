package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import model.user.UserDao;
import model.user.UserResponseDto;

public class MemberListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = UserDao.getInstance();
		
		ArrayList<UserResponseDto> list = userDao.findAll();

		String url ="";
		System.out.println("list : "+list);
		if(list != null){
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			
			url ="/memberList";
			
		}else {
			url="/index";
		}
		
		response.sendRedirect(url);
		
	}

}
