<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" href="/resource/style/form.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<!-- <button>가입</button> -->
	<!-- form 안에 button태그는 submit 동작을 하게됨 -->
	<form method="POST" action="/api/user/join" id="form">
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
				
				
				<div class="group">
					<input type="text" name="name" id="name" placeholder="이름">
					<input type="text" name="birth" id="birth" placeholder="생년월일">
					
					<input type="radio" name="gender" id="male" value="male" checked>
					<input type="radio" name="gender" id="female" value="female">
					
					<div id="gender">
						<label for="male" id="for-male">
							<div>남자</div>
						</label>
						<label for="female" id="for-female">
							<div>여자</div>
						</label>
					</div>
					
					
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
					
					<input type="text" name="pnum" id="pnum" placeholder="휴대폰번호 3자-4자-4자">
				</div>
				
				<div class="error-msg">
					<ul>
						<li id="nameCheck">이름은 필수 입력값입니다.</li>
						<li id="birthCheck">생년월일은 필수 입력값입니다.</li>
						<li id="genderCheck">성별은 필수 선택값입니다.</li>
						<li id="telCheck">통신사는 필수 선택값입니다.</li>
						<li id="pnumCheck">핸드폰 번호는 필수 입력값입니다.</li>
					
					</ul>
				</div>
		
			<input type="button" value="join" onclick="checkForm(form)" id="btn-submit">
		</div>
	</form>
	<script src="resource/script/vaildation.js"></script>
</body>
<jsp:include page="/footer"></jsp:include>
</html>