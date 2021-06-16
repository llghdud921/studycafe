<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제페이지</title>

<link rel="stylesheet" type="text/css" href="css/ticket.css">

<style type="text/css">
	@font-face {
   font-family : 'InterparkGothicMedium';
   src:url('./font/InterparkGothicMedium.ttf') format('truetype');
   }
   body {
      font-family: InterparkGothicMedium;
   }
</style>
<script type="text/javascript">
	function pay() {
		alert('결제되었습니다');
		javascript: location.href = 'ticket_update.do?time='+${time};
		
	}
</script>
</head>
<body>
	<a><img src="./images/logo.png" id="logo_img"></a>
<body id="A">
	<h2>결제</h2>
	<hr>

	<table>
		<thead>
			<tr>
				<th colspan="3">구매정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>총 결제 시간</td>
				<td>${time}시간</td>
			</tr>
		</tbody>
	</table>
	<p>
	<table>
		<thead>
			<tr>
				<th colspan="3">최종 결제 금액</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>결제 금액</td>
				<td>${money}원</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th>총 결제금액</th>
				<th>${money}원</th>
			</tr>
		</tfoot>
	</table>
	<p>
	<p>
		<input class="btn_1" type="button" value="결제" onclick="pay()">
		<input class="btn_2" type="button" value="이전화면"
			onclick="location.href='ticketView.do'">
</body>