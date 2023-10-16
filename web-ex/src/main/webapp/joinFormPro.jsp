<%@page import="java.util.ArrayList"%>
<%@page import="user.UserResponseDto"%>
<%@page import="user.UserRequestDto"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//java 문장안 작성하기
		//response 내장객체 활용 -> sendRedirect() 호출, mypage로 이동
		
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
		
		
		//UserResponseDto responseUser = userDao.findByUsername(username);
		//System.out.println("responseUser : "+responseUser);
		
		ArrayList<UserResponseDto> list = userDao.findAll();
		System.out.println("list : "+list);
		
		System.out.println(userDao.getSize());
		
		
		if(result){
			response.sendRedirect("/login");
		}else{
			response.sendRedirect("/join");
		}
		
	%>
</body>
</html>