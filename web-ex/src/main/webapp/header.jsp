<%@page import="model.user.UserResponseDto"%>
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
	
	<nav>
		<ul>
			<li><a href="/">홈</a></li>
			
	<% 
	UserResponseDto responseUser = (UserResponseDto) session.getAttribute("responseUser");
	if(responseUser == (null)){
	%>		
			<li><a href="/join">회원가입</a></li>
			<li><a href="/login">로그인</a></li>
		<%
	}else{
		%>	
			<li><%= responseUser.getName() %>님 환영합니다.</li>
			<li><a href="/Service?command=logout">로그아웃</a></li>
		<%
	}
	%>	
			<li><a href="/mypage">마이페이지</a></li>
			<li><a href="/Service?command=board">게시판</a></li>
			<li><a href="/Service?command=memderList">회원목록 조회</a></li>
		</ul>
	</nav>

	
</body>
</html>