<%@page import="user.UserResponseDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<% 
		ArrayList<UserResponseDto> list =(ArrayList)session.getAttribute("list");
	%>
	
</head>
<jsp:include page="/header"></jsp:include>
<body>
	
	
		<table style="text-align: center; margin: auto;">
	<%
		for(int i=0; i<list.size(); i++){ 
	%>
			<tr>
				<td><%= list.get(i).getUsername() %></td>
				<td><%= list.get(i).getPassword() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getBirth() %></td>
				<td><%= list.get(i).getGender() %></td>
				<td><%= list.get(i).getTel() %></td>
				<td><%= list.get(i).getPnum() %></td>
			</tr>
	<%
		}
	%>
	</table>
</body>
<jsp:include page="/footer"></jsp:include>
</html>