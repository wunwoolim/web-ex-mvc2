<%@page import="model.board.BoardResponseDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/style/board.css">
<title>board</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<div class="container">
	        <h2>게시판 내용</h2>
		<table style="text-align: center; margin: auto;">
			<tr>
                <th>번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>작성일</th>
                <th>수정일</th>
            </tr>
            
            <tbody>
		        <c:forEach items="${sessionScope.boardList}" var="boardList" varStatus="info">
		            <tr>
		                <td>${info.count}</td>
		                <td>${boardList.name }</td>
		                <td><a href="/boardContents?id=${boardList.id }">${boardList.title }</a></td>
		                <td>${boardList.in_date }</td>
		                <td>${boardList.up_date }</td>
		            </tr>
		        </c:forEach>
		   </tbody>
	    </table>
	    <c:if test="${!empty responseUser}">
			<button><a href="/boardCreate">글쓰기</a></button>
		</c:if>
	</div>
</body>
<jsp:include page="/footer"></jsp:include>
</html>