<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
#paper {
	border: black solid 3px;
}
</style>
<script type="text/javascript">
	function initHaha() {
		// id가 paper인 객체 불러오기
		var paper = document.getElementById("paper");

		var pen = paper.getContext("2d");

		pen.fillRect(10, 10, 50, 50); // x, y, w, h

		pen.fillStyle = "#FF0000";
		pen.fillRect(30, 30, 50, 50);

		pen.save(); // 그림자없는 상태 저장

		pen.fillStyle = "green";
		pen.shadowOffsetX = 3;
		pen.shadowOffsetY = 3;
		pen.shadowColor = "blue";
		pen.shadowBlur = 5;
		pen.fillRect(50, 50, 50, 50);

		pen.restore(); // 저장해놓은거 불러오기

		var i = new Image();
		i.src = "img/Cherry64.png";
		i.onload = function() {
			// pen.drawImage(i, 70, 70); // i, x, y
			pen.drawImage(i, 70, 70, 100, 100); // i, x, y, w, h
		};

	}
</script>
</head>
<%
	// onload : body에 넣어놓은거 화면에 다 나오고 나서
%>
<body onload="initHaha();">
	<canvas id="paper" width="300px" height="500px"></canvas>
</body>
</html>




