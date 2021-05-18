<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
<body>
	<%
		//표현식을 사용하면, 꺼내고 캐스팅하고 이랬는데
		String name = (String)request.getAttribute("name");
		int age = (int)request.getAttribute("age");
	%>
	
	<h3>이름: <%=name%></h3>
	<h3>나이: <%=age%></h3>
	
	<!-- 표현언어(EL)을 사용하면 -->
	<!-- 위에서 꺼내는거 안써도 됨 그냥 전달받은것 그대로 사용 -->
	<h3>이름: ${name}</h3>
	<h3>나이: ${age}</h3>
</body>
</html>