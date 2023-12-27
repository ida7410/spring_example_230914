<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt library</title>
</head>
<body>
	<h1>1. 숫자 출력</h1>
	<c:set var="number" value="12345678" />
	<fmt:formatNumber value="${number}" />
	
	<h3>Type</h3>
	숫자: <fmt:formatNumber value="${number}" type="number" /><br>
	숫자: <fmt:formatNumber value ="${number}" type="number" groupingUsed="false" /><br>
	
	<%-- percentage --%>
	100%: <fmt:formatNumber type="percent" value="1" /><br>
	40%: <fmt:formatNumber type="percent" value="0.4" /><br>
	
	<%-- currency --%>
	원: <fmt:formatNumber value="${number}" type="currency" /><br>
	달러: <fmt:formatNumber value="${number}" type="currency" currencySymbol="$" /><br>
	
	<h3>Pattern</h3>
	3.14: <fmt:formatNumber value="3.14"/><br>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000" /><br>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####" /><br>
	3.141592653(#.####): <fmt:formatNumber value="3.14" pattern="#.####" /><br>
	
	<hr>
	
	<h1>Date 객체를 String 형태로 출력(fmt:formatDate)</h1>
	Date: ${now}<br>
	<fmt:formatDate value="${now}" pattern="yyyy/MM/dd, HH:mm:ss"/><br>
	<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH:mm:ss" var="pattern2" /><br>
	pattern2: ${pattern2}
	
	<h1>String을 Date객체로 변환(fmt:parseDate)</h1>
	<fmt:parseDate value="${pattern2}" pattern="yyyy년 MM월 dd일 HH:mm:ss" />
	
</body>
</html>