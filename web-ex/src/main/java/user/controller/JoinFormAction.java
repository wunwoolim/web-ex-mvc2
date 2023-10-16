package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.UserDao;
import user.UserRequestDto;

public class JoinFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
		
		System.out.println("result : "+ result);
		
		if(result){
			response.sendRedirect("/login");
		}else{
			response.sendRedirect("/join");
		}
		
	}

}
