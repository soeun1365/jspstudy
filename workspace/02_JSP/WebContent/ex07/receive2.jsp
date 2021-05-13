<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>

	<!--
		디폴트 생성자로 만든 빈
		Person p = new Person();
		위 문장이 아래에 useBean으로 만든것
	-->
	<jsp:useBean id="p" class="ex07.Person"></jsp:useBean>
	
	<%--
		setter 로 데이터 주입하기
		p.setName(request.getParameter("name"));
		p.setAge(request.getParameter("age"));
	 --%>
	 <jsp:setProperty property="*" name="p"/>
	 
	 <!-- 출력 방법1 -->
	 	<h3>이름: <jsp:getProperty property="name" name="p"/></h3>
		<h3>나이: <jsp:getProperty property="age" name="p"/></h3>
		
	 <!-- 출력 방법2 --> 
		 <h3>이름: <%=p.getName()%></h3>
		 <h3>나이: <%=p.getAge()%></h3>
</body>
</html>