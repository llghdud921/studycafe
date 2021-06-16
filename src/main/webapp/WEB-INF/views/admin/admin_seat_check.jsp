<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %> 
<%@ page import="com.work.spring03.dto.Member" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좌석 확인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/move.css">
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


</style>

<script type="text/javascript">

</script>

</head>


<body>

<div id="B">
<h3>현재 선택한 자리번호는 ${seatNum} 번입니다.  입실처리하시겠습니까?</h3>
<br>
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("membernonelist");
%>
	<table id="member_table">
		<caption id="tb_title">이용 가능 회원</caption>
		<tr>
			<th>이름</th>
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
		<td><a href="admin_seatInsert.do?name=<%=name%>&seat=${seatNum}"><%= dto.getName() %></a></td>
		<td><%= dto.getRTime() %></td>
		<td><%= dto.getPhone() %></td>
		</tr>
	<%
		}
	%>
	</table>


<label>
   <input class="btn_2" type="button" value="이전화면"  onclick="javascript:location.href='admin_seatView.do'">
</label>

</div>
</body>
</html>