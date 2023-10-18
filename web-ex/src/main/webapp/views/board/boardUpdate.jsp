<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdate</title>
<link rel="stylesheet" href="/resource/style/board.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<div class="container">
        <h2>게시판 글 수정하기</h2>
        <form action="/Service" id="form">
        <input type="hidden" name="command" value="boardUpdate">
        
        	 <c:forEach items="${sessionScope.boardList}" var="boardList" varStatus="info">
        	 	<c:if test="${boardList.id eq param.id}">
			        <input type="hidden" name="id" value="${boardList.id }">
		            <label for="title">수정할 제목</label>
		            <input type="text" id="title" name="title" value=${boardList.title }>
		
		            <label for="content">수정할 본문</label>
		            <textarea id="content" name="contents" style="height:200px">${boardList.contents }</textarea>
		            <label for="title">수정일</label>
		            <input type="text" id="up_date" name="up_date" value=${boardList.up_date }>
	            </c:if>
			</c:forEach>
			
	        <input type="submit" value="수정하기">
        </form>
    </div>
</body>
<script src="resource/script/vaildation.js"></script>
<jsp:include page="/footer"></jsp:include>
</html>