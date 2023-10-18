<%@page import="model.user.UserResponseDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	
	
	<table style="text-align: center; margin: auto;">
	
		<c:forEach items="${sessionScope.list }" var="list" varStatus="info">
				<tr>
					<td>${info.count}</td>
					<td>${list.username }</td>
					<td>${list.password }</td>
					<td>${list.name }</td>
					<td>${list.birth }</td>
					<td>${list.gender }</td>
					<td>${list.tel }</td>
					<td>${list.pnum }</td>
				</tr>
		</c:forEach>
	
	</table>
</body>
<jsp:include page="/footer"></jsp:include>
</html>