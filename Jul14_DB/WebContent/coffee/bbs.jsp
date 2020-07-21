<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="coffeeTbl">
		<tr>
			<td align="right"><a href="CoffeeRegController" id="coffeeRegGo">[메뉴등록]</a>
			</td>
		</tr>
		<tr>
			<td align="center" style="height:450px;">
				<table id="coffeeBBS">
					<tr>
						<th>메뉴명</th>
						<th>가격</th>
					</tr>
					<c:forEach var="c" items="${coffees }">
						<tr class="dataTr" onclick="goCoffeeInfo('${c.c_name}');">
							<td style="width:70%;">${c.c_name }</td>
							<td align="right">
								<fmt:formatNumber value="${c.c_price }" type="number" />원
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="CoffeePageController?pp=${p }">${p }</a>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="center">검색</td>
		</tr>
	</table>
</body>
</html>

