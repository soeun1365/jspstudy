<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%--
		if문
		1. <c:if text="조건식"></c:if>
		2. else 개념이 없다.
	 --%>
	 
	 <%-- parameter로 전달되고 있는 a와 b중에서 큰수를 출력하기 --%>
	 ${param.a gt param.b}<br>	<!-- 잘못된비교, a와 b는 문자열이기 때문 -->
	 ${param.a - param.b gt 0}	<!-- 올바른 비교 -->
	 
	 <c:if test="${param.a - param.b gt 0}">
	 	<c:set var="max" value="${param.a}" />
	 </c:if>
	 
	 <!-- else가 없어서 if또 세워줘야함 -->
	 <c:if test="${param.a - param.b lt 0}">
	 	<c:set var="max" value="${param.b}" />
	 </c:if>
	 
	 <h3>${param.a}와 ${param.b}중 큰 수는 ${max}이다.</h3>
	 
	 <%--a 와 b중에서 10과 가까운 수를 출력하시오 --%>
	 <c:if test="${param.a - 10 gt 0}">
	 	<c:set var="diff1" value="${param.a - 10}" />
	 </c:if>
	 <c:if test="${param.a - 10 lt 0}">
	 	<c:set var="diff1" value="${10 - param.a}" />
	 </c:if>
	 <c:if test="${param.b - 10 gt 0}">
	 	<c:set var="diff2" value="${param.b - 10}" />
	 </c:if>
	 <c:if test="${param.b - 10 lt 0}">
	 	<c:set var="diff2" value="${10 - param.b}" />
	 </c:if>
	 
	 <c:if test="${diff1 - diff2 gt 0}">
	 	<h3>${param.a}와 ${param.b}중 10과 가까운 수는 ${param.a}이다.</h3>
	 </c:if>
	 <c:if test="${diff1 - diff2 lt 0}">
	 	<h3>${param.a}와 ${param.b}중 10과 가까운 수는 ${param.b}이다.</h3>
	 </c:if>
	 <c:if test="${diff1 eq diff2}">
	 	<h3>${param.a}와 ${param.b}는 10과 같은 차이를 가진다.</h3>
	 </c:if>
	 
	 
</body>
</html>