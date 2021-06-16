<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.work.spring03.dto.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/join.css">
<title>내 정보 수정</title>
<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}
input[class="btn_1"] {
	background-color: #BCEE68;
	margin-top: 10px;
	width: 100px;
	height: 30px;
	border-radius: 20px 20px;
	font-family: InterparkGothicMedium;
}

input[class="btn_2"] {
	background-color: white;
	margin-top: 10px;
	margin-left: 10px;
	width: 100px;
	height: 30px;
	border-radius: 20px 20px;
	font-family: InterparkGothicMedium;
}

table {
	margin-top: 15px;
	margin-bottom: 15px;
	margin-left: auto;
	margin-right: auto;
	font-family: InterparkGothicMedium;
}

#logo_img {
	width: 65px;
	height: 50px;
}
</style>

<script type="text/javascript">
	function deleteinfo() {
		if (confirm('탈퇴하시겠습니까?')) {
			javascript: location.href = 'delete.do';
		} else {
			return false;
		}
	}
</script>

<%
	Member dto = (Member) request.getAttribute("dto");
%>

<body>
	<div align="center">
		<img src="./images/logo.png" id="logo_img"><br> <label
			id="logo_down">JSW CAFÉ 내 정보 수정을 위한 정보를 입력해주세요.</label>
	</div>

	<hr>
	<div style="display: inline;" align="center">
		<form action="updateView.do" method="post">
			<table id="body" style="line-height: 170%">

				<!-- 아이디(이메일) -->
				<tr>
					<td>이메일</td>
					<td><input class="input_signup" type="text" name="email"
						value="<%=dto.getEmail()%>" disabled></td>
				</tr>

				<!-- 비밀번호 -->
				<tr>
					<td>비밀번호</td>
					<td><input class="input_signup" type="password"
						name="password" value="<%=dto.getPassword()%>" required><br>
					</td>
				</tr>

				<!-- 이름 -->
				<tr>
					<td>이름</td>
					<td><input class="input_signup" type="text" name="name"
						value="<%=dto.getName()%>" required></td>
				</tr>

				<!-- 휴대폰 -->
				<tr>
					<td>휴대폰</td>
					<td><input class="input_signup" type="text" name="phone"
						maxlength='11' value="<%=dto.getPhone()%>" required></td>
				</tr>
			</table>

			<input class="btn_1" type="submit" value="확인"> <input
				class="btn_1" type="button" value="탈퇴" onclick="deleteinfo()">
			<input class="btn_2" type="button" value="취소"
				onclick="javascript:location.href='mainView.do'">
		</form>
	</div>
</body>
</html>