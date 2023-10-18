<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<h1>삭제 하시겠습니까?</h1>
	<form action="/Service" id="form">
        <input type="hidden" name="command" value="boardDelete">
    	<input type="hidden" name="id" value="${param.id }">
		<input type="submit" value="삭제하기">
		<button><a href="/board">취소하기</a></button>
	</form>
</body>
<jsp:include page="/footer"></jsp:include>
</html>