<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용권 구매 여부 확인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/seat_check.css">
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
	
</script>
</head>
<body>
	<div id="B">
		<h3>회원님의 이용권이 없습니다. 이용권 구매페이지로 넘어가시겠습니까?</h3>
		<br> <label> <input class="btn_1" type="button"
			value="확인" onclick="javascript:location.href='ticketView.do'">
			<input class="btn_2" type="button" value="이전화면"
			onclick="javascript:location.href='seatList.do'">
		</label>

	</div>
</body>
<!-- 점검 완료 -->
</html>
