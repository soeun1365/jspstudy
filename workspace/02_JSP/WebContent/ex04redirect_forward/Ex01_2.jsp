<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 포워드 이동
	// 기존 요청(request)을 그대로 전달한다.
	// 서버내 이동으로 이동할 경로에서 contextPath는 작성하지 않는다.
	RequestDispatcher dispatcher = request.getRequestDispatcher("Ex01_3.jsp");
	dispatcher.forward(request, response);
	
	// 위 두줄을 한줄로 하면
	// request.getRequestDispatcher("Ex01_3.jsp").forward(request, response);

%>