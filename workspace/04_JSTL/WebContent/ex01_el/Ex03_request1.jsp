<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//request에 "속성(Attribute)"으로 데이처 저장
	request.setAttribute("name", "브레드");
	request.setAttribute("age", 50);
	
	//request를 유지한 상태로 이동 -> forward
	request.getRequestDispatcher("Ex03_request2.jsp").forward(request, response);
%>