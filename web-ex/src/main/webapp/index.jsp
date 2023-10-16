<%-- 주석 --%>
<%-- java Server page : jsp --%>
<%-- html 문서 안에 작성된 java 언어 --%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.UserResponseDto"%>
<%@page import="user.UserRequestDto"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header"></jsp:include>
<body>
	
	<sction>
		<p>Hello world</p>
	</sction>
	<%
		UserDao dao = UserDao.getInstance();
		dao.findById(1234);
		
	%>
	
</body>
<jsp:include page="/footer"></jsp:include>
</html>