<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.work.spring03.dto.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 이용 인원 관리 페이지</title>
<link rel="stylesheet" type="text/css" href="css/atag.css">

<style type="text/css">
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}


body {
   font-family: InterparkGothicMedium;
}
/* 회원조회 table 설정 */
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

/* 회원 조회 table caption 설정*/
#tb_title {
	font-size: 30px;
	font-weight: bold;
	font-color: #74A155;
	padding-bottom: 10px;
}

/* 회원 조회 페이지 버튼*/
input[class="member_check1"] {
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

input[class="member_check2"] {
	background-color: white;
	color: #74A155;
	font-size: 13px;
	width: 100px;
	height: 40px;
	border: solid #74A155 1px;
	border-radius: 15px 15px;
	margin-top: 10px;
	float: right;
	margin-right: 10px;
	font-family: InterparkGothicMedium;
}

input[type="submit"].member_check1:hover {
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
<hr>
	<div align="center">
		<div id="header">
			<a href="admin_seatView.do" title="자리관리">자리관리</a>&nbsp;|&nbsp; <a
				href="admin_memberList.do" title="회원조회">회원조회</a>&nbsp;|&nbsp; <a
				href="admin_ticket.do" title="이용권관리">이용권관리</a>&nbsp;|&nbsp;
			<a href="loginView.do" title="로그아웃">로그아웃</a>&nbsp;
		</div>

		<hr>
		<br>

		<%
			ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("memberwholelist");
		%>
		<table id="member_table">
			<caption id="tb_title">전체 인원</caption>
			<tr>
				<th>이름</th>
				<!-- <th>현재 사용 시간</th> -->
				<th>이용권 남은 시간</th>
				<th>전화번호</th>
			</tr>
			<%
				for (int index = 0; index < list.size(); index++) {
					Member dto = list.get(index);
					String name = dto.getName();
			%>
			<tr>
				<td><a href="admin_detailmember.do?name=<%=name%>"><%=dto.getName()%></a></td>
				<td><%=dto.getRTime()%></td>
				<td><%=dto.getPhone()%></td>
			</tr>
			<%
				}
			%>
		</table>

		<input class="member_check1" type="submit" name="member_check"
			value="이전화면" onclick="javascript:location.href='admin_memberList.do'">

	</div>

</body>
</html>