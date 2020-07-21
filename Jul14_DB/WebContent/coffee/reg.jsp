<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="CoffeeRegController" method="post" name="coffeeRegForm"
		onsubmit="return coffeeRegCheck();">
		<table id="coffeeRegTbl">
			<tr>
				<th>메뉴등록</th>
			</tr>
			<tr>
				<td align="center"><input name="name" placeholder="메뉴명"
					maxlength="10" autocomplete="off" autofocus="autofocus"></td>
			</tr>
			<tr>
				<td align="center"><input name="price" placeholder="가격"
					maxlength="5" autocomplete="off"></td>
			</tr>
			<tr>
				<td align="center">
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>