<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>애들은 가라</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		int age = Integer.parseInt(request.getParameter("age"));
	%>
	<h3>미성년자입니다.</h3>
	<div>
		당신의 나이는 <%=age%>이므로 주류 구매가 불가능합니다.
	</div>
	<br><br>
	<a href="/02_JSP/quiz/Quiz02_1.jsp">처음으로 이동</a>
</body>
</html>