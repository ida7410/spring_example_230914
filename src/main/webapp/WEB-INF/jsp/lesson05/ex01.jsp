<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core Library(1)</title>
</head>
<body>
	<h1>1. 변수 정의 (c:set)</h1>
	<c:set var="number1" value="100" />
	<c:set var="number2">250</c:set>
	number1: ${number1}<br>
	number2: ${number2}<br>
	number1 + number2: ${number1 + number2}
	
	<h1>2. 변수 출력하기 (c:out)</h1>
	<c:out value="Hello World" /><br>
	<c:out value="${number1}" /><br>
	
	<%-- 문자열 escape  --%>
	<c:out value="<script>alert('alert')</script>" /><br>
	<c:out value="<script>alert('alert')</script>" escapeXml="true" /><br>
	<%-- <c:out value="<script>alert('alert')</script>" escapeXml="false" /><br> --%>
	
	<h1>3. 조건문(c:if)</h1>
	<c:if test="${number1 > 50}">
		number1 is greater than 50<br>
	</c:if>
	
	<c:if test="${number1 == 100 }">
		number1 equals 100<br>
	</c:if>
	<c:if test="${number1 eq 100 }">
		number1 equals 100<br>
	</c:if>
	
	<c:if test="${number1 != 50 }">
		number1 is not 50<br>
	</c:if>
	<c:if test="${number1 ne 50 }">
		number1 is not 50<br>
	</c:if>
	
	<c:if test="${empty number1}">
		number1 is empty<br>
	</c:if>
	<c:if test="${!empty number1}">
		number1 is not empty<br>
	</c:if>
	<c:if test="${not empty number1}">
		number1 is not empty<br>
	</c:if>
	
</body>
</html>