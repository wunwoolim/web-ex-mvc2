<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 채점</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>정답</th>
			<th>사용자값</th>
			<th>정오표</th>
		</tr>
		
		<%
			request.setCharacterEncoding("UTF-8");
			String[] num = request.getParameterValues("num");
			String[] answer = request.getParameterValues("answer");
			
			int score = 100;
			for(int i=0; i<num.length; i++){
			
		%>
			<tr>
				<td><%= i+1 %></td>
				<td><%= answer[i]%></td>
				<td><%= num[i]%></td>
				<td><%= answer[i].equals(num[i]) ? "O":"X" %></td>
			</tr>
			<%
				score = answer[i].equals(num[i]) ?  score : score-20;
			%>
			
		<% }%>
	</table>
	<h1>당신의 점수<%= score %> 점 입니다 </h1>
</body>
</html>