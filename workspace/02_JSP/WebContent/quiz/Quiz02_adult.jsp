<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int age = Integer.parseInt(request.getParameter("age"));
%>

<script>
	alert('성인입니다. 당신의 나이는 <%=age%>이므로 주류 구매가 가능합니다.');
	// forward는 이동경로(URL)가 변하지 않는 이동이므로 history에 잡히지 않는다.
	// 따라서 history.go(-2)가 아니라 history.go(-1) 또는 history(back)을 해야한다.
	history.back();
</script>