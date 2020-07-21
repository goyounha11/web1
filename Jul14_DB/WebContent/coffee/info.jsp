<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<br><br><br><br><br><br>
	<table id="coffeeInfoTbl">
		<form action="CoffeeUpdateController" name="coffeeUpdateForm" onsubmit="return coffeeUpdateCheck();">
			<tr><th><input name="name"   value="${c.name }" readonly="readonly" id="coffeeInfoName"></th></tr>
			<tr><td><input name="price" 
							value="${c.price }" 
							id="coffeeInfoPrice"
							autocomplete="off"><br><br><br><br></td></tr>
			<tr><td align="center">
				<button>수정</button>
		</form>
				<button onclick="deleteCoffee('${c.name}');">삭제</button>
			</td></tr>	
		</table>
</body>
</html>







