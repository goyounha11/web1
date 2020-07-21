<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function getRandColor() {
		// Math.random() // 0.0 ~ 1.0
		// Math.random() * 255 // 0.0 ~ 255.0
		var r = Math.round(Math.random() * 255); // 0 ~ 255
		var g = Math.round(Math.random() * 255);
		var b = Math.round(Math.random() * 255);
		return "rgb(" + r + "," + g + "," + b + ")";
	}

	function init() {
		var a4 = document.getElementById("paper");
		var brush = a4.getContext("2d");

		var img = new Image();
		img.src = "img/ball.png";
		var ballX = 7;
		var ballY = 3;
		var xSpd = 7;
		var ySpd = 7;
		img.onload = function() {
			setInterval(function() {
				brush.save();
				brush.fillStyle = "rgba(0, 0, 0, 0.1)";
				brush.fillRect(0, 0, 400, 500);
				brush.shadowColor = "red";
				brush.shadowBlur = 30;
				if (ballX >= 370 || ballX <= 0) {
					xSpd *= -1;
				}
				if (ballY >= 470 || ballY <= 0) {
					ySpd *= -1;
				}
				ballX += xSpd;
				ballY += ySpd;
				brush.drawImage(img, ballX, ballY);
				brush.shadowColor = "white";
				var x = Math.random() * 400;
				var y = Math.random() * 500;
				brush.fillStyle = getRandColor();
				brush.fillRect(x, y, 10, 10);

				brush.restore();
			}, 30);
		};
	}
</script>
</head>
<body onload="init();">
	<canvas id="paper" width="400px" height="500px"></canvas>
</body>
</html>