<%@ page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		중복되지 않은 구구단 랜덤 문제를 5개 기출하고
		사용자가 빈칸에 답을 입력한 후
		제출을 하면 -> 정오표와 함께 성적이 출력된다.(100점 만점)
		* 요청 form에서는 사용자에게 정답이 노출되지 않도록 할 것 
	 --%>
	 <h1>구구단 문제</h1>
	 <form method="POST" action="gugudanPro.jsp">
	 
	 <table border="1">
	 <tr>
	 	<th>번호</th>
	 	<th>문제</th>
	 	<th>정답</th>
	 </tr>
	 
	 <% 
	 	Random ran = new Random();
	 	
		for(int i=0; i<5; i++){
			int num1 = ran.nextInt(10);
			int num2 = ran.nextInt(10);
			if(num1 == 0 || num2 ==0){
				num1++; num2++;
			}
			int x = (int) Math.floor(Math.random()*(9-2+1))+2;
			int y = (int) Math.floor(Math.random()*(9-2+1))+2;
			int z= x*y;
			
	 %>	 
	 <tr>
	 	<td><%= i+1 %></td>
	 	<%-- <td><%= num1 %> * <%= num2 %> =</td> --%>
	 	<td><%= x %> * <%= y %> =</td>
	 	<td>
		 	<input type="text" id="num<%=i%>" name="num">
		 	<%-- <input type="hidden" id="answer<%=i%>" name="answer" value="<%= num1*num2 %>"> --%>
		 	<input type="hidden" id="answer<%=i%>" name="answer" value="<%= z %>">
	 	</td>
	 	
	 </tr>	 
	 <%} %>
	 </table>
	 <input type="submit">
	 </form>
</body>
</html>