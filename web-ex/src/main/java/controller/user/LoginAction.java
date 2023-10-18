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
		//로그인 처리 로직
				// 파마미터 값 넘어옴
				// 유저의 비밀번호가 일치하는지
				// 일치하면 -> mypage
				// session log
				// 불일치하면 -> login
				String username =	request.getParameter("username");
				String password =	request.getParameter("userpassword");
				
				System.out.println(username+password);
				
				UserDao userDao = UserDao.getInstance();
				
				UserResponseDto responseUser = userDao.findByUsername(username,password);
				
				System.out.println("responseUser : "+ responseUser);
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
