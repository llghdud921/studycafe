<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.work.spring03.dto.Time"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 방문 조회 페이지</title>
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

input.member_check {
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

input.member_check:hover {
	background-color: #74A155;
	color: white;
}
</style>

</head>
<body>
	<%
		ArrayList<Time> list = (ArrayList<Time>) request.getAttribute("memberdetaillist");
	%>

	<div align="center">

		<hr>

		<h1>회원 방문 기록</h1>


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
				<td><%="--"%></td>
			</tr>
			<%
				}
				}
			%>


		</table>
		<input class="member_check" type="submit" name="member_check"
			value="홈 화면으로 " onclick="javascript:location.href='mainView.do'">
	</div>

</body>
</html>