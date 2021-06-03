<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<a href="/11_MYBATIS/insertPage.do">새글 작성</a>
	<br><br><br>
	
	<form action="/11_MYBATIS/findList.do">
		<select name="column">
			<option value="TITLE">내용</option>
			<option value="AUTHOR">작성자</option>
			<option value="BOTH">내용+작성자</option>
		</select>
		<input type="text" name="query">
		<button>검색</button>
	</form>
	전체 게시글: ${totalRecord}개<br>
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>제목</td>
				<td>작성자</td>
				<td>최종수정일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">작성된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="dto" items="${list}" varStatus="k">
					<tr>
						<td>${seq - k.index}</td>
						<td>
						<c:if test="${dto.depth == 1}">
							&nbsp;&nbsp;[re]
						</c:if>
						${dto.title}
						<c:if test="${dto.depth == 0}">
							<font size="1"><a href="/11_MYBATIS/insertReplyPage.do?groupno=${dto.groupno}">답글</a></font>
							<%-- 여기서 dto.no를 붙여서 넘겨줘야 댓글에서 댓글페이지에서 게시글의 no를 알 수 있다. --%>
						</c:if>
						</td>	
						<td>${dto.author}</td>
						<td>${dto.lastmodified}</td>
						<td>${dto.hit}</td>
					</tr>
					<tr class="insert_reply">
						<!-- 댓글 작성란 -->
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">${paging}</td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>