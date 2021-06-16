<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 이용권 구매</title>
<link rel="stylesheet" type="text/css" href="css/ticket.css">
<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}
</style>

<script type="text/javascript">
	function pay_check() {

		var size = document.getElementsByName("buyticket").length;
		for (var i = 0; i < size; i++) {
			if (document.getElementsByName("buyticket")[i].checked) {
				var str = document.getElementsByName("buyticket")[i].value;
				javascript: location.href = 'pay.do?time=' + str;
			}
		}
	}
</script>
</head>
<body id="A">
<a><img src="./images/logo.png" id="logo_img"></a>

	<h2>개인 이용권 구매</h2>
	<hr>
	<h4>구매하려는 이용시간을 선택하세요</h4>
	<table border="1">
		<tbody>
			<tr>
				<td>1시간 : 2000원<input type="radio" name="buyticket" value="1"
					checked></td>
			</tr>
			<tr>
				<td>2시간 : 3500원<input type="radio" name="buyticket" value="2"></td>
			</tr>
			<tr>
				<td>3시간 : 4500원<input type="radio" name="buyticket" value="3"></td>
			</tr>
			<tr>
				<td>4시간 : 5500원<input type="radio" name="buyticket" value="4"></td>
			</tr>
			<tr>
				<td>5시간 : 6500원<input type="radio" name="buyticket" value="5"></td>
			</tr>
			<tr>
				<td>6시간 : 7500원<input type="radio" name="buyticket" value="6"></td>
			</tr>
		</tbody>
	</table>
	<p>
		<input class="btn_1" type="button" value="확인" onclick="pay_check()">
		<input class="btn_2" type="button" value="이전화면"
			onclick="javascript:location.href='mainView.do'">
</body>
</html>