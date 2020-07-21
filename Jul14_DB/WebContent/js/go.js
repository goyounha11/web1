function goCoffeeInfo(n) {
	// 고구마라떼  -euc-kr->  %2A
	
	// JS로 URL인코딩 처리(utf-8)
	n = encodeURIComponent(n); 
	location.href = "CoffeeInfoController?name=" + n;
}

function deleteCoffee(n){
	location.href = "CoffeeDeleteController?name=" + n;
}