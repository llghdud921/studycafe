<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.work.spring03.dto.Seat"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/atag.css">
<link rel="stylesheet" type="text/css" href="css/seat.css">
<style type="text/css">
#seat_div1 {
	margin-left: 30px;
}

#seat_table1 {
	margin-left: 250px;
}
@font-face {
   font-family: InterparkGothicMedium;
   src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
   font-family: InterparkGothicMedium;
}

#logo_img{
   width:65px;
   height:50px;
   margin-left:67px;
   
}

</style>
<script>
	function seat(x) {
		location.href = 'admin_seatSelect.do?seat=' + x;
	}
</script>
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
	<%
		ArrayList<Seat> list = (ArrayList<Seat>) request.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
			Seat s = list.get(i);
		}
	%>

	<div id="seat_div1">
		<header>
			<h3>관리자 ${sessionScope.name} 님</h3>
			<h3>현재 자리 현황</h3>
			<img src="./images/dot1.png" width="8px" height="8px">&nbsp;<label>이용가능</label>
			<img src="./images/dot2.png" width="8px" height="8px">&nbsp;<label>이용중</label>
		</header>

		<%
			int i = 0;
			for (int a = 0; a < 2; a++) {
		%>
		<table id="seat_table1">
			<%
				for (int b = 0; b < 2; b++) {
			%>
			<tr>
				<%
					for (int j = 0; j < 4; j++) {

								Seat sdto = list.get(i++);
								String TF = sdto.getSeatTF();
								String gender = sdto.getGender();
								String name = sdto.getName();

								int ut = sdto.getUseTime();
								String str;
								if (TF.equals("T")) {
				%>
				<td><input class="user_ocp_f" type="button" name="seat"
					value="<%=name%>" onclick="seat('<%=i%>');"></td>
				<%
					} else {
				%>
				<td><input class="user_ocp" type="button" name="seat"
					value="좌석<%=i%>" onclick="seat('<%=i%>');"></td>
				<%
					}
							}
				%>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>

	</div>
</body>
</html>