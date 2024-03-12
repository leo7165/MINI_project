<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>osLoginForm</title>

<style type = "text/css">

.div1{
	background : #e6e6e6;
	border : 1px;
	width : 300px;
	height : 300px;
	margin : 100px auto;
}

</style>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$("#mid").attr('placeholder','아이디');
	$("#mpw").attr('placeholder','비밀번호');
	
	$("#btn").click(function(){
		console.log("btn >>> : ");
		
		$('#osloginForm').attr({
			'action' : "login.h",
			'method' : 'POST',
			'enctype' : 'application/x-www-form-urlencoded'
			
		}).submit();
		
	});
});

</script>

</head>
<body>
<div class = "div1">
<hr>
<h1 align="center">OS로그인</h1>
<hr>
<form name = "osloginForm" id="osloginForm">
<table border="0" align="center">

<tr>
<th>ID</th>
<td><input type="text" name="mid" id="mid" style="width:150px;"></td>
</tr>

<tr>
<th>PASSWORD</th>
<td><input type="text" name="mpw" id="mpw" style="width:150px;"></td>
</tr>

<tr>
<td><a href="idCreateForm.h"><font size="1">회원가입</font></a><br>
<a href="idFindForm.h"><font size="1">아이디/비밀번호 찾기</font></a>
<td align="right">
<button type="button" id="btn" style="width:60px; height:35px;">LOGIN</button>
</td>
</tr>
</body>
</html>