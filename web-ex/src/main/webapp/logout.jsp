<%@page import="user.UserResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%
	UserResponseDto responseUser = (UserResponseDto) session.getAttribute("responseUser");
	if(responseUser != null){
		session.invalidate();
	}
	response.sendRedirect("/login");
	%>
</body>
</html>