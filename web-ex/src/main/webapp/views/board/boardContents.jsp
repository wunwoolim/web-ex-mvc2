<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardContents</title>
<link rel="stylesheet" href="/resource/style/board.css">
</head>
<jsp:include page="/header"></jsp:include>

<body>
    <div class="container">
        <h2>게시판 내용</h2>
        <form action="/Service" id="form">
        <input type="hidden" name="command" value="">
        <div class="content">
	        <c:forEach items="${sessionScope.boardList}" var="boardList" varStatus="info">
	            <c:if test="${boardList.id eq param.id}">
	               <p>제목 <input type="text" name="title" value="${boardList.title}" readonly></p>
	               <p>내용<input type="text" name="contents" value="${boardList.contents}" readonly></p>
	               <p>작성자<input type="text" name="name" value="${boardList.name}" readonly></p>
	               <p>날짜<input type="text" name="up_date" value="${boardList.up_date}" readonly></p>
	                
	                <c:if test="${boardList.user_id eq responseUser.id}">
				        <button><a href="/boardUpdate?id=${boardList.id}">수정하기</a></button>
				        <button><a href="/boardDelete?id=${boardList.id}">삭제하기</a></button>
        			</c:if>	
	            </c:if>
	                        	            
	       </c:forEach>
        </div>
        </form>
    </div>
    
    
    <script src="/resource/script/script.js"></script>
</body>
<jsp:include page="/footer"></jsp:include>
</html>