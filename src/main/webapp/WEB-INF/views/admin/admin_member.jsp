<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList" %> 
<%@ page import="com.work.spring03.dto.Member" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 이용 인원 관리 페이지</title>
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
	<div style="text-align:center">
   <hr>
   <a href="admin_seatView.do" title="자리관리">자리관리</a>&nbsp;|&nbsp;
   <a href="admin_memberList.do" title="회원조회">회원조회</a>&nbsp;|&nbsp;
   <a href="admin_ticket.do" title="이용권관리">이용권관리</a>&nbsp;|&nbsp;
   <a href="admin_logOut.do" title="로그아웃">로그아웃</a>&nbsp;
   <hr>
   </div>
	<br>
	<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("memberuserlist");
%>
	<table id="member_table">
		<caption id="tb_title">현재 이용 인원</caption>
		<tr>
			<th>이름</th>
			<!-- <th>현재 사용 시간</th> -->
			<th>이용권 남은 시간</th>
			<th>전화번호</th>
		</tr>
		<%
		for (int index=0; index < list.size(); index++) {
			Member dto = list.get(index);
			String name = dto.getName();
			System.out.println(name);
	%>
		<tr>
		<td><a href="admin_detailmember.do?name=<%= name%>"><%= dto.getName() %></a></td>
		<td><%= dto.getRTime() %></td>
		<td><%= dto.getPhone() %></td>
		</tr>
	<%
		}
	%>
	</table>

	<input class="member_check" type="submit" name="member_check"
		value="전체 인원 보기"
		onclick="javascript:location.href='admin_memberwholeList.do'">


</body>
</html>