<%@page import="user.UserResponseDto"%>
<%@page import="user.UserRequestDto"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%-- JSP의 내장객체 
	out
	request 요청처리
	response 응답처리
	page
	pageCintext
	config
	session
	application
	exception
 --%>

<body>
	<h1>Pro</h1>
	<%
		request.setCharacterEncoding("UTF-8");
		String username =	request.getParameter("username");
		String userpassword =	request.getParameter("userpassword");
		
		UserDao userDao = UserDao.getInstance();
		
		UserRequestDto user = new UserRequestDto(username,userpassword);
		
		boolean result = userDao.duplicatedUser(user);
		
		if(result == true){
			UserResponseDto responseUser = userDao.findByUsername(username);
			System.out.println("responseUser : "+responseUser);
			
			session.setAttribute("responseUser",responseUser);
			
			response.sendRedirect("/index");
		}else if(result == false){
			response.sendRedirect("/login");
		}
		
	%>
	
</body>
</html>