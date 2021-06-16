<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퇴실 확인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/move.css">
<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}

</style>

</head>


<body>

<div id="B">
<h3>${name}님의 자리 변경하시겠습니까?</h3>
<br>


<label>
   <input class="btn_1" type="button" value="퇴실"  onclick="javascript:location.href='admin_seatOut.do?name=${name}'">
    <input class="btn_1" type="button" value="이동"  onclick="javascript:location.href='admin_seatMoveList.do?name=${name}'">
   <input class="btn_2" type="button" value="이전화면"  onclick="javascript:location.href='seatList.do'">
</label>

</div>
</body>
</html>