<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디카페 회원페이지</title>
<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}
input[type="submit"] {
	font-size: 20px;
	background-color: #BCEE68;
	margin-top: 10px;
	width: 180px;
	height: 80px;
	border-radius: 20px 20px;
	font-family: INTERPARKGOTHICMEDIUM;
}
#logo_img {
	width: 65px height:50px border: inset 5px pink
}
h4 {
	margin-left: 500px;
}
</style>
<script type="text/javascript">
function showClock()
{
   var currentDate = new Date();
   var divClock = document.getElementById("divClock");
  
   var msg = "";
          
   msg += currentDate.getMinutes()+"분 ";
   msg += currentDate.getSeconds()+"초 ";
   
   if(currentDate.getHours()<=12){
    
    msg = currentDate.getHours()+"시 ";
       
       msg += currentDate.getMinutes()+"분 ";
       msg += currentDate.getSeconds()+"초 ";
   }
   else if(currentDate.getHours()>=13){
    
msg = currentDate.getHours()+"시 ";
       
       msg += currentDate.getMinutes()+"분 ";
       msg += currentDate.getSeconds()+"초 ";
    
   }
   
   divClock. innerText = msg;
   
   setTimeout(showClock,1000);
}

</script>
<body  onload="showClock()">

	<div align="center">
		<h1>
			<img src="./images/logo.png">
		</h1>
	</div>
	<div style="margin-left:500px;" id="divClock" class="clock"></div>
	
	<h4>*현재 ${sessionScope.use}</h4>
	<h4>*사용 가능한 시간 ${sessionScope.time} 분</h4>
	<div align="center">

		<input type="submit" name="" value="이용권구매"
			onclick="javascript:location.href='ticketView.do'">
		<input type="submit" name="" value="자리현황"
			onclick="javascript:location.href='seatList.do'">
			 <input
			type="submit" name="" value="방문 내역 조회"
			onclick="javascript:location.href='visitmember.do'"><br><input
			type="submit" name="" value="내정보수정"
			onclick="javascript:location.href='update.do'"> <input
			type="submit" name="" value="이용 가이드"
			onclick="javascript:location.href='guideView.do'"> <input
			type="submit" name="" value="로그아웃"
			onclick="javascript:location.href='logout.do'"><br>
	</div>

</body>
</html>