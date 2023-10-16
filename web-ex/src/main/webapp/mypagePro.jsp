<%@page import="user.UserResponseDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.UserRequestDto"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">

<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		
		UserDao userDao = UserDao.getInstance();
		
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
		   	
		    ArrayList<UserResponseDto> list = userDao.findAll();
			System.out.println("list : "+list);
			
			response.sendRedirect("/logout");
		}else if(check.equals("deleteCheck")){
			String username =	request.getParameter("username");
			String userpassword =	request.getParameter("userpasswordDel");
			
			System.out.println("username : "+username);
			System.out.println("userpassword : "+userpassword);
			
			UserRequestDto userCheck = new UserRequestDto(username,userpassword);
			boolean deldate = userDao.delsetUser(userCheck);
			
			System.out.println("deldate : "+deldate);
			
			ArrayList<UserResponseDto> list = userDao.findAll();
			
			System.out.println("list : "+list);
			response.sendRedirect("/logout");
		}
		
		
	%>
	
</body>
</html>