function goCoffeeInfo(n) {
	// ������  -euc-kr->  %2A
	
	// JS�� URL���ڵ� ó��(utf-8)
	n = encodeURIComponent(n); 
	location.href = "CoffeeInfoController?name=" + n;
}

function deleteCoffee(n){
	location.href = "CoffeeDeleteController?name=" + n;
}