<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/style/board.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<div class="container">
        <h2>게시판 글쓰기</h2>
        <form action="/Service" id="form">
        <input type="hidden" name="command" value="boardCreate">
        <input type="hidden" name="id" value="${responseUser.id }">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.." required>

            <label for="content">본문</label>
            <textarea id="content" name="content" placeholder="내용을 입력해주세요.." style="height:200px" required></textarea>
			
            <input type="button" value="등록" onclick="boardCreate(form)">
        </form>
    </div>
</body>
<script src="resource/script/vaildation.js"></script>
<jsp:include page="/footer"></jsp:include>
</html>