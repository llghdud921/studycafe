<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login 화면</title>
<link rel="stylesheet" type="text/css" href="css/atag.css">

<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}
.login {
	background-color: #74A155;
	font-size: 13px;
	width: 100px;
	height: 30px;
	border-radius: 15px 15px;
	font-family: InterparkGothicMedium;
}
</style>
<body>
	<h3>${message}</h3>
	<div align="center">
		<h1>
			<img src="./images/logo.png">
		</h1>
		<hr>
		<h3>로그인</h3>

		<form action="admin_login.do" method="post">
			<!-- 이메일 -->
			<input type="email" name="email" placeholder="아이디(이메일)"><br>

			<!-- 비밀번호 -->
			<input type="password" name="password" placeholder="비밀번호" style="margin: 10px"><br>

			<!-- 버튼 -->
			<input class="login" type="submit" value="로그인">
		</form>

		<hr>
		<a href="admin_join.do" title="회원가입">회원가입</a>&nbsp;|&nbsp; <a
			href="loginView.do" title="회원 로그인">회원 로그인</a>&nbsp;

	</div>
</body>
</html>