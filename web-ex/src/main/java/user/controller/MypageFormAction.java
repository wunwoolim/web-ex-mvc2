package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDao;
import user.UserRequestDto;
import user.UserResponseDto;

public class MypageFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MypageFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		
		UserDao userDao = UserDao.getInstance();
		HttpSession session = request.getSession();
		
		System.out.println("check : "+check);
		if(check.equals("passwordCheck")){
			String userpassword =	request.getParameter("userpassword");
			UserRequestDto userCheck = new UserRequestDto(userpassword);
			boolean result = userDao.passwoerUser(userCheck);
			
			if(result){
				session.setAttribute("result", result);
				response.sendRedirect("/mypage");
			}else{
				session.setAttribute("result", result);
				response.sendRedirect("/mypage");
			}
		}else if(check.equals("updateCheck")){
			String username =	request.getParameter("username");
			String userpassword =	request.getParameter("userpasswordUp");
			String name =	request.getParameter("name");
			String birth =	request.getParameter("birth");
			String gender =	request.getParameter("gender");
			String tel =	request.getParameter("tel");
			String pnum =	request.getParameter("pnum");
			UserRequestDto userCheck = new UserRequestDto(username,userpassword,name,birth,gender,tel,pnum);
		    boolean update = userDao.setUser(userCheck);
		    
		    System.out.println("update : "+update);
		   	
			response.sendRedirect("/logout");
			
		}else if(check.equals("deleteCheck")){
			String username =	request.getParameter("username");
			String userpassword =	request.getParameter("userpasswordDel");
			
//			System.out.println("username : "+username);
//			System.out.println("userpassword : "+userpassword);
			
			UserRequestDto userCheck = new UserRequestDto(username,userpassword);
			//boolean deldate = userDao.delsetUser(userCheck);
			
			//System.out.println("deldate : "+deldate);
			
			ArrayList<UserResponseDto> list = userDao.findAll();
			
			System.out.println("list : "+list);
			response.sendRedirect("/logout");
		}
	}

}
