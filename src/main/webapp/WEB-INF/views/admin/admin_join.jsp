<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원가입 페이지</title>
<style type="text/css">
table {
   margin-left: 500px;
   align: center;
}
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}

input[class="btn"] {
  background-color: white;
   font-size: 13px;
   font-weight: bold;
   width: 100px;
   height: 30px;
   border-radius: 15px 15px;
   text-align: center;
   font-family: InterparkGothicMedium;
}

input[class="btn_join"] {
   background-color: #BCEE68;
   font-size: 13px;
   font-weight: bold;
   width: 100px;
   height: 30px;
   border-radius: 15px 15px;
   text-align: center;
   font-family: InterparkGothicMedium;
}

#logo_img{
   width:65px;
   height:50px;
   
}
</style>

<script type="text/javascript">
   function tochpw() {
      var pw1 = document.getElementById("pw1").value;
      var pw2 = document.getElementById("pw2").value;

      if (pw1 != pw2) {
         alert('비밀번호가 틀렸습니다. 다시 입력해주세요.');
         return false;
      } else {
         alert('비밀번호가 맞습니다. 다음 정보를 입력해주세요.');
         return ture;
      }
   }
   
   function idCheck() {
         var email = document.getElementById("email").value;
         window.open("idcheckView.do?email=" + email, "detailWindow", "width=500, height=400");
      }
</script>
</head>



<body id="A">
   <header>
      <div align="center">
         <br> <img src="./images/logo.png" id="logo_img"><br> <label id="logo_down">JSW CAFÉ 관리자 회원가입을 위한 정보를 입력해주세요.</label>
      </div>
   </header>

   <hr>
   <div>

      <form action="admin_join.do" method="post">
         <!-- 이메일 -->
         <table>
            <tr>
               <td>이메일 &nbsp;<input class="input_signup" type="text" name="email" id="email" style="width:300px; margin-left:65px;" placeholder="이메일"
                  required ></td>
               <td><input type="button" class="btn" value="ID 중복확인" onclick="idCheck()"></td>
            </tr>

         <!-- 비밀번호 -->
            <tr>
               <td>비밀번호 &nbsp;<input id="pw1"
                  class="input_signup" type="password" name="password"
                  style="width:300px; margin-left:50px;" placeholder="비밀번호 "  required><br>
               </td>
            </tr>

         <!-- 비밀번호확인 -->
            <tr>
               <td>비밀번호 재확인 &nbsp;<input id="pw2" class="input_signup"
                  type="password" name="password_check" placeholder="비밀번호 확인" style="width:300px;" required></td>
               <td><input type="button" class="btn" value="PW 재확인" onclick="tochpw()"></td>
            </tr>

         <!-- 이름 -->
            <tr>
               <td>이름 &nbsp;<input class="input_signup" type="text"  name="name" placeholder="이름" style="width:300px; margin-left:80px;" required></td>
            </tr>
         </table>
		<br>
         <input class="btn_join" type="submit" value="회원가입" style="margin-left: 650px">         
            <input class="btn" type="button" value="취소" style="margin-left: 10px" onclick="javascript:location.href='aloginView.do'">
      </form>               
   </div>
   

</body>
</html>