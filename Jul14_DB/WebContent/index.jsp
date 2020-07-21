<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Jul14</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/weather.css">
<link rel="stylesheet" href="css/loc.css">
<link rel="stylesheet" href="css/coffee.css">
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/jul15Check.js"></script>
<script type="text/javascript" src="js/info.js"></script>
<script type="text/javascript" src="js/go.js"></script>
</head>
<c:choose>
	<c:when test="${r != null }">
		<body onload="showAlert('${r}');">
	</c:when>
	<c:otherwise>
		<body>
	</c:otherwise>
</c:choose>
<table id="siteTitleArea">
	<tr>
		<td align="center"><a href="HomeController">192.168.0.81/Jul14_DB</a>
		</td>
	</tr>
</table>
<table id="siteContentArea">
	<tr>
		<td align="center"><jsp:include page="${contentPage }"></jsp:include>
		</td>
	</tr>
</table>
<table id="siteMenuArea">
	<tr>
		<td align="right"><a href="WeatherController">날씨</a></td>
	</tr>
	<tr>
		<td align="right"><a href="LocController">장소검색</a></td>
	</tr>
	<tr>
		<td align="right"><a href="GController">HTML5 Graphics</a></td>
	</tr>
	<tr>
		<td align="right"><a href="DBController">DB테스트</a></td>
	</tr>
	<tr>
		<td align="right"><a href="CoffeeController">커피</a></td>
	</tr>
</table>
<img src="img/b.jpg" id="indexImg">
</body>
</html>