<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ page import="java.util.ArrayList" %> 
<%@ page import="com.work.spring03.dto.Seat" %>   
<!DOCTYPE html>
<html>
<title>자리 선택 페이지</title>
<head>
<link rel="stylesheet" type="text/css" href="css/seat.css">
<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}
</style>
<script>

	function seat(x){
		location.href='seatSelect.do?seat='+x;
	}

</script>
</head>
<body>
<%
ArrayList<Seat> list = (ArrayList<Seat>)request.getAttribute("list");
String myName = (String)session.getAttribute("name");
%>

<header>
<div id="seat_div1">
	<h3>${name} 님 환영합니다</h3>
   <h3>현재 자리 현황</h3>
   <img src="./images/dot1.png" width="8px" height="8px">&nbsp;<label>이용가능</label>
   <img src="./images/dot2.png" width="8px" height="8px">&nbsp;<label>이용중</label>
</header>
</div>
<% int i=0;
for(int a = 0; a < 2; a++){
	%>
	<table id="seat_table1"><% 
	for(int b=0;b<2;b++){
		%>
		<tr><% 
		for(int j=0;j<4;j++){
			
	
   Seat sdto = list.get(i++);
   String TF = sdto.getSeatTF();
   String gender = sdto.getGender();
   String name = sdto.getName();
   String g;
   if(gender=="M")
	   g="남";
   else
	   g="여";
   int ut = sdto.getUseTime();
   String str;
   if(TF.equals("T")){
	   if(name.equals(myName)){
		   %>
		   <td><input class="user_ocp_f" type = "button" name="seat" value="<%="내자리!"%>" onclick="seat('<%=i%>');"></td>
		   <% 
	   }else{
	   %>
	   <td><input class="user_ocp_f" type = "button" name="seat" value="<%=name%>" onclick=" alert('다른 사람이 사용중입니다.');"></td>
	 <% 
	   }
	   
   }else {
	   %>
	<td><input class="user_ocp" type = "button" name="seat" value="좌석<%=i%>" onclick="seat('<%=i%>');"></td>
<% }}
		
	%></tr> <% } %></table><% }%>
	<br>
	<input class="seat_btn" type = "button" onclick="javascript:location.href='mainView.do'" name="home" value="홈 화면으로 "   style="background-color:#BCEE68"> 
</body>
</html>