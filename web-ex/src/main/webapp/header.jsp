<%@page import="user.UserResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/style/grid.css">
<title>The Joeun JSP MVC1</title>
</head>
<body>
	<header>
		<h1>The Joeun JSP MVC1</h1>
	</header>
	<% 
	UserResponseDto responseUser = (UserResponseDto) session.getAttribute("responseUser");
	if(responseUser == (null)){
	%>
	<nav>
		<ul>
			<li><a href="/join">회원가입</a></li>
			<li><a href="/login">로그인</a></li>
			<li><a href="/mypage">마이페이지</a></li>
		</ul>
	</nav>
	<%
	}else{
		%>
	<nav>
		<ul>
			<li><%= responseUser.getName() %>님 환영합니다.</li>
			<li><a href="/logout">로그아웃</a></li>
			<li><a href="/mypage">마이페이지</a></li>
		</ul>
	</nav>
	<%
	}
	%>
</body>
</html>