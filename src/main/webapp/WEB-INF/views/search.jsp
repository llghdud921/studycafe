<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기 페이지</title>
<style type="text/css">
td.find_title {
   color: darkgreen;
   font-size: 17px;
   font-weight: bold;
   font-family: InterparkGothicMedium;
}
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}
/* 아이디 찾기/비밀번호 버튼 설정 */
input[class="find"] {
   background-color: white;
   font-size: 13px;
   font-weight: bold;
   width:100px;
   height:30px;
   border-radius:15px 15px;
   font-family: InterparkGothicMedium;
   margin-top:5px;
}

/* 로그인버튼 설정 */
input[class="login"] {
   background-color: #BCEE68;
   font-size: 13px;
   font-weight: bold;
   width:100px;
   height:30px;
   border-radius:15px 15px;
   font-family: InterparkGothicMedium;
}

#logo_img {
   width:65px;
   height:50px;
}
</style>
</head>
<body>
   <h3>결과메세지 : ${notice}</h3>
   <hr>
   <div id="wrap" align="center">
      <a href="loginView.do"><img src="./images/logo.png" alt="로고" id="logo_img"
         title="Home"></a>


      <form action="searchid.do" method="post">
         <table id="find_table" style="line-height:170%">
            <tr>
               <td class="find_title" colspan="3">1. 아이디 찾기<br></td>
            </tr>

            <!-- 휴대폰 번호로 아이디(이메일) 찾기 -->

            <tr>
      <td>이름</td>
      <td><input type="text" name="name" required autofocus></td>
      <td rowspan="2"></td>
      </tr>

            <tr>
               <td>휴대폰 번호</td>
               <td><input type="text" name="phone" placeholder="-없이 입력"
                  required></td>
            </tr>
            <tr>
               <td rowspan="2"><input class="find" type="submit"
                  value="아이디 찾기"></td>
            </tr>
         </table>
      </form>
      <p>
         <!-- 이메일 주소로 비밀번호 찾기 -->
         <form action="searchpw.do" method="post">
      <table id="find_table" style="line-height:170%">
            

            <tr>
               <td>이름</td>
               <td><input type="text" name="name" required></td>
            </tr>

            <tr>
               <td>이메일 주소</td>
               <td><input type="text" name="email"
                  required></td>
            </tr>

            <tr>
               <td>휴대폰 번호</td>
               <td><input type="text" name="phone" placeholder="-없이 입력"
                  required></td>
            </tr>
            <tr>
               <td><input class="find" type="submit" value="비밀번호 찾기"></td>
            </tr>
      </table>

      </form>
      <input class="login" type="submit" name="login" value="로그인창"
         onclick="location.href='loginSessionView.do'">

   </div>
</body>
</html>