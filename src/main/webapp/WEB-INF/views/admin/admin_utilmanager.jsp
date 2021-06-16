<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 이용권 관리 페이지</title>
<link rel="stylesheet" type="text/css" href="css/atag.css">
<style type="text/css">
@font-face {
	font-family: InterparkGothicMedium;
	src: url('./font/InterparkGothicMedium.ttf') format('truetype');
}

body {
	font-family: InterparkGothicMedium;
}

#logo_img {
	width: 65px;
	height: 50px;
	margin-left: 67px;
}
</style>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : ['corechart','bar']
	});
	google.charts.setOnLoadCallback(drawChart);
	
	function drawChart() {

		var data = google.visualization.arrayToDataTable([
			 ['요일', '남','여'],
			 ${result}
		]);

		var options = {
			title : '요일별 사용자',
			chartArea : {
				width : '50%'
			}
		};

		var chart = new google.visualization.ColumnChart(document.getElementById('piechart'));

		chart.draw(data, options);
	}
</script>
</head>

<body>
	<div style="margin-left: 650px;">
		<h1>
			<img src="./images/logo.png" id="logo_img">
		</h1>
	</div>
	<div align="center">
		<hr>
		<a href="admin_seatView.do" title="자리관리">자리관리</a>&nbsp;|&nbsp; <a
			href="admin_memberList.do" title="회원조회">회원조회</a>&nbsp;|&nbsp; <a
			href="admin_ticket.do" title="이용권관리">이용권관리</a>&nbsp;|&nbsp; <a
			href="admin_logOut.do" title="로그아웃">로그아웃</a>&nbsp;
		<hr>
	</div>
	<div style="margin-left: 100px; margin-top: 50px" id="piechart"
		style="width: 900px; height: 500px;"></div>

</body>
</html>