<%@page import="model.user.UserDao"%>
<%@page import="model.user.UserResponseDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/resource/style/form.css">
<title>mypage</title>
<jsp:include page="/header"></jsp:include>
<body>

	 <c:if test="${empty responseUser}">
		<c:redirect url="/login"/>
	</c:if>
	
	<form method="POST" action="/Service" id="form">
		<h1>${ sessionScope.responseUser.getName()}님 환영합니다.</h1>
		
		<c:if test="${empty result}">

		<div>
			<h3>회원 정보 인증</h3>
			<div class="group">
					<input type="password" name="userpassword" id="userpassword" placeholder="비밀번호 확인">
			</div>
					<input type="hidden" name="command" value="passwordCheck" id="passwordCheck">
					<input type="button" value="passwordCkeck" onclick="passwordCkeck(form)" id="btn-submit">
			<div class="error-msg">
						<ul>
						<li id="passwordCheck">비밀번호는 필수 입력값입니다.</li>
					</ul>
			</div>
		</div>
		</c:if>
		<c:if test="${!empty result}">
		<div id="update">
			
			<div class="group">
				<h3>회원 정보 변경</h3>
				<input type="text" name="username" id="username" placeholder="아이디" value= ${sessionScope.responseUser.getUsername() } readonly>
				<input type="password" name="userpasswordUp" id="userpasswordUp" placeholder="비밀번호" value = ${sessionScope.responseUser.getPassword() } >
				<input type="text" name="name" id="name" placeholder="이름" value = ${sessionScope.responseUser.getName() }>
				<input type="text" name="birth" id="birth" placeholder="생년월일" value=${sessionScope.responseUser.getBirth() } readonly>
				<input type="text" name="gender" id="gender" value=${sessionScope.responseUser.getGender() } readonly>
				<input type="radio" name="tel" id="STK" value="STK" checked>
				<input type="radio" name="tel" id="KT" value="KT">
				<input type="radio" name="tel" id="LG" value="LG U+">
						
				<div id="tel">
						<label for="STK" id="for-STK">
							<div>STK</div>
						</label>
						<label for="KT" id="for-KT">
							<div>KT</div>
						</label>
						<label for="LG" id="for-LG">
							<div>LG U+</div>
						</label>
				</div>
				
				<input type="text" name="pnum" id="pnum" placeholder="휴대폰번호 3자-4자-4자" value = ${sessionScope.responseUser.getPnum() }>
			</div>
			
			<div class="error-msg">
				<ul>
					<li id="telCheck">통신사는 필수 선택값입니다.</li>
				</ul>
			</div>
			
			<input type="button" value="변경하기" onclick="updateUser(form)" id="btn-submit">
			
		</div>
		
		<div id="delete">
			<div class="group">
			<h3>회원 탈퇴</h3>
				<input type="password" name="userpasswordDel" id="userpasswordDel" placeholder="비밀번호">
			</div>
			<div class="error-msg">
				<ul>
					<li id="passwordCheckDel">비밀번호는 필수 입력값입니다.</li>
				</ul>
			</div>
			<input type="hidden" name="username" id="username" value= ${sessionScope.responseUser.getUsername() }>
			
			<input type="button" value="탈퇴하기" onclick="deleteUser(form)" id="btn-submit">
		</div>
		<input type="hidden" name="command" value="" id="checkValue">
		</c:if>
	</form>
	
	<script src="resource/script/vaildation.js"></script>
</body>
<jsp:include page="/footer"></jsp:include>
</html>