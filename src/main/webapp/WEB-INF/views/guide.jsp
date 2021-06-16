<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용가이드 화면</title>
<style type="text/css"> 
   @font-face {
   font-family : 'InterparkGothicMedium';
   src:url('./font/InterparkGothicMedium.ttf') format('truetype');
   }
   body {
      font-family: InterparkGothicMedium;
   }

#table_one {
   width:400px; 
    height:200px;
    text-align : center;
}

#table_time {
   width:400px; 
    height:150px;
    text-align : center;
}

input[class="btn"]{
    background-color:#74A155;
    color: white;
    font-size: 20px; 
    margin-top:10px; 
    margin-left:600px;
    width:200px; 
    height:50px;
    border-radius:20px 20px;
    font-family: InterparkGothicMedium;
}

#logo_img{
   width:130px;
   height:100px;
}

</style>
</head>
<body>

<div style="margin-left:650px;">
<h1><img src="./images/logo.png" id="logo_img"></h1>
</div>

<div style="float: right; width: 40%;" align="center">
<hr>
 <h1>이용가격안내</h1>
                
                 <table id="table_one" border="1" cellspacing="0" >
                 <tr><td colspan="2">&nbsp;1인좌석&nbsp;(1회권)</td></tr>
                 <tr><td>&nbsp;1시간</td><td>&nbsp;2000원</td></tr>
                 <tr><td>&nbsp;2시간</td><td>&nbsp;3500원</td></tr>
                 <tr><td>&nbsp;3시간</td><td>&nbsp;4500원</td></tr>
                 <tr><td>&nbsp;4시간</td><td>&nbsp;5500원</td></tr>
                 <tr><td>&nbsp;5시간</td><td>&nbsp;6500원</td></tr>
                 <tr><td>&nbsp;6시간</td><td>&nbsp;7500원</td></tr>
                 </table>
                 <br>
                <p></p>
                   
                   <table id="table_time" border="1" cellspacing="0">
                   <tr><td colspan="2">&nbsp;정액권</td></tr> 
                    <tr><td>&nbsp;50시간</td><td>&nbsp;70,000원</td></tr>
                    <tr><td>&nbsp;100시간</td><td>&nbsp;120,000원</td></tr>
                    </table>      
                    
 <br></div>
                    <p></p>
                    
<div style="float: left; width: 60%;" align="center">
<hr>     
  <h1>좌석이용안내</h1><p>
  <h2 style="color:#f76868">01 좌석 선택 방법</h2><p>     
  <img class="slide" src="./images/guide11.PNG" width="800px" height="400px"><p>
  1. 이용권 구매 후 자리현황을 클릭합니다.<p><br><br>
  <img class="slide" src="./images/guide22.PNG" width="400px" height="120px"><p>
  2. 좌석을 선택하면 사용 가능합니다.<p><br><br>
  <hr>
  <h2 style="color:#f76868">02 좌석 이동 방법</h2><p>
  <img class="slide" src="./images/guide33.PNG" width="800px" height="400px"><p>
  1. 내가 앉아있는 좌석을 선택한다.<p><br><br>
  <img class="slide" src="./images/guide44.PNG" width="400px" height="120px"><p>   
  2. 이동을 클릭한다.<p><br><br>
  <img class="slide" src="./images/guide55.PNG" width="800px" height="400px"><p>
  3. 이동 할 자리를 선택한다.<p><br><br>
  <img class="slide" src="./images/guide66.PNG" width="400px" height="120px"><p>
  4. 사용하기를 클릭한다.<p><br><br>
  <img class="slide" src="./images/guide77.PNG" width="800px" height="400px"><p>
  5. 자리이동 완료.<p><br><br>
  <hr> 
  <h2 style="color:#f76868">03 퇴실 방법</h2><p>
  <img class="slide" src="./images/guide77.PNG" width="800px" height="400px"><p>
  1. 내가 앉아있는 좌석을 선택한다.<p><br><br>
  <img class="slide" src="./images/guide44.PNG" width="400px" height="120px"><p>
  2. 퇴실을 클릭한다.<p><br><br>
  <img class="slide" src="./images/guide88.PNG" width="800px" height="400px"><p>
  3.퇴실하기 완료.<p><br><br>

      <input class="btn" type="button" value="이전화면" onclick="javascript:location.href='mainView.do'">                      
 </div>      
</body>
</html>