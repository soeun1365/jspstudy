<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="게시판" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	board_list{
		width: 500px;
		margin: auto;
	}
	input[type="button"]{
		float: right;
	}
	table{
		width: 100%;
		border-collapse: collapse;
	}
	td{
		height: 30px;
		border-collapse: collapse;
		text-align: center;
	}
	td:nth-of-type(1) {width: 70px;}
	td:nth-of-type(2) {width: 200px;}
	td:nth-of-type(3) {width: 70px;}
	td:nth-of-type(4) {width: 70px;}
	td:nth-of-type(5) {width: 70px;}
	
}
</style>
<div class="board_list">
	
	<%-- 로그인을 해야만 게시글을 작성할 수 있다. --%>
	<c:if test="${loginDTO != null}">
		<input type="button" value="게시글 작성하기" onclick="location.href='/10_MODEL2/insertBoardPage.b'">
		<br><hr><br>
	</c:if>
	
	
	<p>전체 : ${totalRecord}개 게시물</p>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>최종수정일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.idx}</td>
					<td>${dto.title}</td>
					<td>${dto.author}</td>
					<td>${dto.hit}</td>
					<td>${dto.lastmodified}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					
				</td>
			</tr>
		</tfoot>
	</table>
	
</div>

<%@ include file="../layout/footer.jsp" %>