<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자리 변경 페이지</title>
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
		<h3>확인 페이지</h3>
		<br> <label> <input class="btn_1" type="button"
			value="퇴실" onclick="javascript:location.href='seatOut.do?'">
			<input class="btn_1" type="button" value="이동"
			onclick="javascript:location.href='seatMoveList.do?'"> <input
			class="btn_2" type="button" value="이전화면"
			onclick="javascript:location.href='seatList.do'">
		</label>
	</div>
</body>
<!-- 점검 완료 -->
</html>