<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복확인</title>

<style type="text/css">
@font-face {
	font-family: InterparkGothicMedium;
	src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
	font-family: InterparkGothicMedium;
}

#A {
	margin-left: 100px;
	margin-right: 100px;
	text-align: center;
}
</style>

</head>

<body id="A">
	<h2>ID 중복확인</h2>
	<hr>

	<h3>아이디 : ${email} ${message}</h3>
	<form action="idcheckView.do" method="post">
		<input class="btn_1" type="submit" name="idcheck" value="확인"
			onclick="window.close()" title="click close">
	</form>
</body>
</html>