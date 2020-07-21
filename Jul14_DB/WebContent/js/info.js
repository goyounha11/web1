function showAlert(txt) {
	// setInterval(함수, 시간); 시간마다 저 함수 호출
	// setTimeout(함수, 시간); 시간지나고 저 함수 호출
	setTimeout(function() {
		alert(txt);
	}, 200);
}