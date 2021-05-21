<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%--형식(포매팅)라이브러리--%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<%-- 변수선언을 위해서 --%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<c:set var="n" value="123456789.123456789"/>
	<h3>쉼표처리(,) : <fmt:formatNumber value="${n}" groupingUsed="true" /></h3>
	<br>
	<h3>쉼표처리(,) : <fmt:formatNumber value="${n}" pattern="#,##0" /></h3>
	<h3>쉼표처리(,) : <fmt:formatNumber value="${n}" pattern="#,##0.0" /></h3>
	<h3>쉼표처리(,) : <fmt:formatNumber value="${n}" pattern="#,##0.00" /></h3>
	<br>
	<h3>쉼표없음 : <fmt:formatNumber value="${n}" pattern="0"/></h3>
	<h3>쉼표없음 : <fmt:formatNumber value="${n}" pattern="0.0"/></h3>
	<h3>쉼표없음 : <fmt:formatNumber value="${n}" pattern="0.00"/></h3>
	<br>
	<h3>퍼센트(백분율) : <fmt:formatNumber value="${n}" type="percent" /></h3>
	<br>
	<h3>통화(원화) : <fmt:formatNumber value="${n}" type="currency" /></h3>
	<h3>통화(다른통화) :<fmt:formatNumber value="${n}" type="currency" currencySymbol="$" /></h3>
	
</body>

</html>