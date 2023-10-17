<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resource/style/form.css">
<title>login</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<form method="POST" action="/Service" >
	<input type="hidden" name="command" id="command" value="login">
		<div>
			<div class="group">
				<input type="text" name="username" id="username" placeholder="아이디">
				<input type="password" name="userpassword" id="userpassword" placeholder="비밀번호">
			</div>
			
			<div class="error-msg">
				<ul>
					<li id="usernameCheck">아이디는 필수 입력값입니다.</li>
					<li id="passwordCheck">비밀번호는 필수 입력값입니다.</li>
				</ul>
			</div>
			
			<input type="button" value="login" onclick="loginCheck(form)" id="btn-submit">
		</div>
	</form>
	<script src="resource/script/vaildation.js"></script>
</body>
<jsp:include page="/footer"></jsp:include>
</html>