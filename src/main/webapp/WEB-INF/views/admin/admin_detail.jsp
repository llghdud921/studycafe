<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.work.spring03.dto.Member"%>
<%@ page import="com.work.spring03.dto.Time"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 세부 조회 페이지</title>
<link rel="stylesheet" type="text/css" href="css/atag.css">
<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}
#current_visit {
	font-size: 18px;
	text-align: left;
	margin-bottom: 10px;
}

#member_table {
	border: 1px solid;
	border-collapse: collapse;
	width: 500px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	font-size: 15px;
}

th, tr, td {
	border: 1px solid;
	padding: 5px;
	margin: 3px;
}

#tb_title {
	font-size: 30px;
	font-weight: bold;
	font-color: #74A155;
	padding-bottom: 10px;
}

input[type="submit"].member_check {
	background-color: white;
	color: #74A155;
	font-size: 13px;
	width: 100px;
	height: 40px;
	border: solid #74A155 1px;
	border-radius: 15px 15px;
	margin-top: 10px;
	float: right;
	margin-right: 510px;
	font-family: InterparkGothicMedium;
}

input[type="submit"].member_check:hover {
	background-color: #74A155;
	color: white;
}
#logo_img{
   width:65px;
   height:50px;
   margin-left:67px;
   
}
</style>

</head>
<div style="margin-left:650px;">
<h1><img src="./images/logo.png" id="logo_img"></h1>
</div>

<body>
	<%
		Member dto = (Member) request.getAttribute("memberdetail");
		ArrayList<Time> list = (ArrayList<Time>) request.getAttribute("memberdetaillist");
		int a = dto.getSTime()/60;
		int b = dto.getSTime()%60;
		String str;
		if(a<1) {
			str = String.valueOf(dto.getSTime()) + " 분";
		}else {
			str = String.valueOf(a) + " 시간" + String.valueOf(b) +" 분";
		}
		
	%>

	<div align="center">

		<div id="header" style="text-align:center">
			<a href="admin_seatView.do" title="자리 관리">자리 관리</a>&nbsp;|&nbsp; <a
				href="admin_memberList.do" title="회원 조회">회원 조회</a>&nbsp;|&nbsp; <a
				href="admin_ticket.do" title="이용권 관리">이용권 관리</a>&nbsp;|&nbsp;
			<a href="admin_logOut.do" title="로그아웃">로그아웃</a>&nbsp;
		</div>

		<hr>

		<h1>회원 세부 조회</h1>

		<div style="padding: 5px;">
			이름:
			<%=dto.getName()%>
		</div>
		<div style="padding: 5px;">
			이메일:
			<%=dto.getEmail()%>
		</div>
		<div style="padding: 5px;">
			휴대폰 번호:<%=dto.getPhone()%>
		</div>
		<div style="padding: 5px;">
			누적 시간:<%= str %>
		</div>

		<br> <br>


		<table id="member_table">
			<caption id="current_visit">방문 내역</caption>
			<tr>
				<th>날짜</th>
				<th>입실 시간</th>
				<th>퇴실 시간</th>
			</tr>
			<%
				SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");

				for (int index = 0; index < list.size(); index++) {
					Time tdto = list.get(index);
					if (tdto.getOutTime() != null) {
						long inTime = Long.parseLong(tdto.getInTime());
						long outTime = Long.parseLong(tdto.getOutTime());
			%>
			<tr>
				<td><%=tdto.getDay()%></td>
				<td><%=timeformat.format(new Date(inTime))%></td>
				<td><%=timeformat.format(new Date(outTime))%></td>
			</tr>
			<%
				} else {
						long inTime = Long.parseLong(tdto.getInTime());
			%>
			<tr>
				<td><%=tdto.getDay()%></td>
				<td><%=timeformat.format(new Date(inTime))%></td>
				<td><%= "--" %></td>
			</tr>
			<%
				}
				}
			%>


		</table>

		<input class="member_check" type="submit" name="member_check"
			value="이전화면" onclick="javascript:location.href='admin_memberwholeList.do'">
	</div>

</body>
</html>