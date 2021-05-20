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
	<c:set var = "average" value="${(param.kor + param.eng + param.mat) div 3}" />
	
	<!-- if 태그로 학점(grade) 계산하기 -->
	<!-- else가 안되서 if는 너무 까다로움 
	<c:if test="${average - 90 ge 0}">
		<c:set var="grade" value="A"/>
	</c:if>
	<c:if test="${average - 90 lt 0 and average - 80 ge 0}">
		<c:set var="grade" value="B"/>
	</c:if>
	<c:if test="${average - 80 lt 0 and andaverage -70 ge 0}">
		<c:set var="grade" value="C"/>
	</c:if>
	<c:if test="${average - 70 lt 0 and andaverage - 0 ge 0}">
		<c:set var="grade" value="D"/>
	</c:if>
	<c:if test="${average - 60 lt 0}">
		<c:set var="grade" value="F"/>
	</c:if>
	-->
	<!-- choose태그로 학점(grade) 계산하기 -->
	<!-- chooese태그의 서브 태그인 when태그는 else의 개념을 가지고 있다. -->
	<c:choose>
		<c:when test="${average - 90 ge 0 }">	<!-- else()와 같음 -->
			<c:set var="grade" value="A"></c:set>
		</c:when>
		<c:when test="${average - 80 ge 0 }">	<!-- else if()와 같음 -->
			<c:set var="grade" value="B"></c:set>
		</c:when>
		<c:when test="${average - 70 ge 0 }">
			<c:set var="grade" value="C"></c:set>
		</c:when>
		<c:when test="${average - 60 ge 0 }">
			<c:set var="grade" value="D"></c:set>
		</c:when>
		<c:otherwise><!-- else()와 같음 -->
			<c:set var="grade" value="F"/>
		</c:otherwise>
	</c:choose>
	${grade}
</body>
</html>