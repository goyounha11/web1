<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="LocController" method="post">
		<input name="what" id="locSearchInput" autocomplete="off"
			autofocus="autofocus">
		<button id="locSearchBtn">찾기</button>
	</form>
	<hr>
	<c:forEach var="l" items="${locs }">
		<table class="l">
			<tr>
				<td class="lName">${l.name }</td>
			</tr>
			<tr>
				<td>${l.address }</td>
			</tr>
			<tr>
				<td align="right">${l.phone }</td>
			</tr>
			<tr>
				<td align="right">${l.distance }m</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>