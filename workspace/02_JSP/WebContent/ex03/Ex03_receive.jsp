<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	if(name.isEmpty()){
		name = "기본이름";
	}
	
	String strAge = request.getParameter("age");
	int age = strAge.isEmpty() ? 0 : Integer.parseInt(strAge);	//삼항연산자
	/* 
	String strAge = request.getParameter("age");
	int age = 0;
	if(strAge.isEmpty()){
		age = 0;
	}else{
		age = Integer.parseInt(strAge);
	}
	*/
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		alert('이름은: <%=name%>, 나이는<%=age%>');
		history.back();
	</script>
</head>
<body>
	
</body>
</html>