<%@page import="java.util.List"%>
<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>전체 회원 정보</title>
</head>
<style>
		.container {
			width: 500px;
			margin: 100px auto;
			text-align: center;
		}
		table{
			width: 100%;
			border-collapse: collapse;
		}
	</style>
<body>
<%
	List<MemberDTO> list = MemberDAO.getInstance().selectAll();

	pageContext.setAttribute("list", list);	//EL사용을 위해 pageContext처리
%>	
	<div class="container">
		<h3>전체 회원 정보</h3>
		<table border="1">
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>비밀번호</td>
					<td>이름</td>
					<td>이메일</td>
					<td>가입일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.no}</td>
						<td>${dto.id}</td>
						<td>${dto.pw}</td>
						<td>${dto.name}</td>
						<td>${dto.email}</td>
						<td>${dto.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6"><input type="button" value="뒤로가기" onclick="history.back()"></td>
				</tr>
			</tfoot>
		</table>
	</div>
	
</body>
</html>