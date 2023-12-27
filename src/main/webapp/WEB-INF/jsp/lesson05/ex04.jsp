<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn Library</title>
</head>
<body>
	<c:set var="str1" value="No pain, No gain." />
	
	<h1>1. Length</h1>
	${fn:length(str1)}
	
	<h2>2. check if string is contained</h2>
	Does No exists? ${fn:contains(str1, 'No')}<br>
	Does no exists? ${fn:contains(str1, "no")}<br>
	
	<c:if test="${fn:containsIgnoreCase(str1, 'No')}">
		No exist in str1. (ignore case)
	</c:if>
	
	<h1>3. check if starts with</h1>
	Does it start with No? ${fn:startsWith(str1, "No")}<br>
	
	<h1>3. check if end with</h1>
	Does it end with No? ${fn:endsWith(str1, "n")}<br>
	Does it end with No? ${fn:endsWith(str1, ".")}<br>
	
	<h1>5. replace</h1>
	<c:set var="str2" value="I want to eat chicken." />
	${str2}<br>
	${fn:replace(str2, "chicken", "soup")}
	
	<h1>6. split</h1>
	${fn:split(str1, ".")}
	${fn:split(str1, ".")[0]}
	${fn:split(str1, ".")[1]}
	
	<h1>7. substring</h1>
	${fn:substring(str2, 14, 21)}
	
	<h1>8. to lower case</h1>
	${fn:toLowerCase(str1)}<br>
	
	<h1>9. to Upper case</h1>
	${fn:toUpperCase(str1)}<br>
	
	<h1>10. </h1>
	<c:set var="str3" value="   h  el l o   " />
	<pre>${str3}</pre>
	<pre>${fn:trim(str3)}</pre>
</body>
</html>