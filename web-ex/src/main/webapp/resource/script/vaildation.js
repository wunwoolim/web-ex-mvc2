/**
 * 
 */
const input_username = document.getElementById("username");
const input_userpassword = document.getElementById("userpassword");
const input_userpasswordUp = document.getElementById("userpasswordUp");
const input_userpasswordDel = document.getElementById("userpasswordDel");
const input_name = document.getElementById("name");
const input_birth = document.getElementById("birth");
const input_gender = document.getElementById("gender");
const input_tel = document.getElementById("tel");
const input_pnum = document.getElementById("pnum");

const error_username = document.getElementById("usernameCheck");
const error_userpassword = document.getElementById("passwordCheck");
const error_userpasswordUp = document.getElementById("passwordCheckUp");
const error_userpasswordDel = document.getElementById("passwordCheckDel");
const error_name = document.getElementById("nameCheck");
const error_birth = document.getElementById("birthCheck");
const error_gender = document.getElementById("genderCheck");
const error_tel = document.getElementById("telCheck");
const error_pnum = document.getElementById("pnumCheck");

const regExp = /^\d{3}-\d{4}-\d{4}$/;

input_username.addEventListener('change', e =>{
	if(input_username.value !== ''){
		input_username.style.borderColor = 'lightgrey';
		error_username.style.display = 'none';
	}
});

input_userpassword.addEventListener('change', e =>{
	if(input_userpassword.value !== ''){
		input_userpassword.style.borderColor = 'lightgrey';
		error_userpassword.style.display = 'none';
	}
});

input_userpasswordUp.addEventListener('change', e =>{
	if(input_userpasswordUp.value !== ''){
		input_userpasswordUp.style.borderColor = 'lightgrey';
		error_userpasswordUp.style.display = 'none';
	}
});

input_userpasswordDel.addEventListener('change', e =>{
	if(input_userpasswordDel.value !== ''){
		input_userpasswordDel.style.borderColor = 'lightgrey';
		error_userpasswordDel.style.display = 'none';
	}
});

input_name.addEventListener('change', e =>{
	if(input_name.value !== ''){
		input_name.style.borderColor = 'lightgrey';
		error_name.style.display = 'none';
	}
});

input_birth.addEventListener('change', e =>{
	if(input_birth.value !== ''){
		input_birth.style.borderColor = 'lightgrey';
		error_birth.style.display = 'none';
	}
});

input_gender.addEventListener('change', e =>{
	if(input_gender.value !== ''){
		input_gender.style.borderColor = 'lightgrey';
		error_gender.style.display = 'none';
	}
});

input_tel.addEventListener('change', e =>{
	if(input_tel.value !== ''){
		input_tel.style.borderColor = 'lightgrey';
		error_tel.style.display = 'none';
	}
});

input_pnum.addEventListener('change', e =>{
	if(input_pnum.value !== ''){
		input_pnum.style.borderColor = 'lightgrey';
		error_pnum.style.display = 'none';
	}
});



const form = document.getElementById("form");
form.addEventListener("submit", e =>{
	e.preventDefault();
	checkForm(form);
});



function checkForm(form){
	
	username = form.username.value;
	userpassword = form.userpassword.value;
	name = form.name.value;
	birth = form.birth.value;
	gender = form.gender.value;
	tel = form.tel.value;
	pnum = form.pnum.value;
	
		
	if(username == ""){
		input_username.style.borderColor = "red";
		error_username.style.display = "block";
	}else if(userpassword == ""){
		input_userpassword.style.borderColor = "red";
		error_userpassword.style.display = "block";
	}else if(name == ""){
		input_name.style.borderColor = "red";
		error_name.style.display = "block";
	}else if(birth == ""){
		input_birth.style.borderColor = "red";
		error_birth.style.display = "block";
	}else if(gender == ""){
		input_gender.style.borderColor = "red";
		error_gender.style.display = "block";
	}else if(tel == ""){
		input_tel.style.borderColor = "red";
		error_tel.style.display = "block";
	}else if(pnum == "" || !regExp.test(pnum)){
		input_pnum.style.borderColor = "red";
		error_pnum.style.display = "block";
	}else{
		form.submit();
	}
	
}

function loginCheck(form){
	username = form.username.value;
	userpassword = form.userpassword.value;
	
	if(username == ""){
		input_username.style.borderColor = "red";
		error_username.style.display = "block";
	}else if(userpassword == ""){
		input_userpassword.style.borderColor = "red";
		error_userpassword.style.display = "block";
	}else{
		form.submit();
	}
}

function passwordCkeck(form){
	userpassword = form.userpassword.value;
	
	if(userpassword == ""){
		input_userpassword.style.borderColor = "red";
		error_userpassword.style.display = "block";
	}else{
		form.submit();
		document.getElementById("certification").style.display="block";
	}
}
	
	
function updateUser(form){
	username = form.username.value;
	userpasswordUp = form.userpasswordUp.value;
	name = form.name.value;
	tel = form.tel.value;
	pnum = form.pnum.value;
	
	
	
	if(userpasswordUp == ""){
		input_userpasswordUp.style.borderColor = "red";
		error_userpasswordUp.style.display = "block";
	}else if(name == ""){
		input_name.style.borderColor = "red";
		error_name.style.display = "block";
	}else if(tel == ""){
		input_tel.style.borderColor = "red";
		error_tel.style.display = "block";
	}else if(pnum == "" || !regExp.test(pnum)){
		input_pnum.style.borderColor = "red";
		error_pnum.style.display = "block";
	}else{
		form.check.value = "updateCheck";
		document.getElementById("checkValue").value = "updateCheck";
		form.submit();
	}
}


function deleteUser(form){
	userpasswordDel = form.userpasswordDel.value;
	
	if(userpasswordDel == ""){
		input_userpasswordDel.style.borderColor = "red";
		error_userpasswordDel.style.display = "block";
	}else{
		form.check.value = "deleteCheck";
		document.getElementById("checkValue").value = "deleteCheck";
		form.submit();
	}
}


	
	
	
	
