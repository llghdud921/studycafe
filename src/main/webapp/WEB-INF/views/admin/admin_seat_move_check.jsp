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

<script type="text/javascript">

</script>

</head>


<body>

<div id="B">
<h3>선택 이름 : ${name} <br> 자리번호 :  ${seatNum}<br> 이동하시겠습니까?</h3>
<br>
<label>
   <input class="btn_1" type="button" value="사용하기"  onclick="javascript:location.href='admin_seatMove.do?seatNum=${seatNum}&name=${name}'">
   <input class="btn_2" type="button" value="이전화면"  onclick="javascript:location.href='admin_seatMoveList.do?name=${name}'">
</label>

</div>
</body>
</html>