<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	요청한 현재 날짜는 ${today}입니다.
	요청한 현재 시간은 ${n ow}입니다.
	<c:forEach var="ball" items = "${lotto}">
		
	</c:forEach>
	<h3>요청한 구구단입니다.</h3>
	${gugudan}<br>
	<h3>${result}</h3>
</body>
</html>