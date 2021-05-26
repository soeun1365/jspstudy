<%@page import="dao.BoardDAO"%>
<%@page import="dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 리스트</title>
	<style>
		.container{
			width: 600px;
			margin: 100px auto;
		}
		a{
			text-decoration: none;
			color: black;
		}
		.container > a:nth-child(2){
			float: right;
		}
		table{
			width:100%;
			border-collapse: collapse;
			text-align: center;	
		}
		th{
			background-color: lightgray;
			height: 30px;
		}
		td{
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
		}
		td:nth-of-type(1) { width: 90px; }
		td:nth-of-type(2) { width: 220px; }
		td:nth-of-type(3) { width: 120px; }
		td:nth-of-type(4) { width: 70px; }
		td:nth-of-type(5) { width: 100px; }
		tr:hover {
			background-color: pink;	
		}
	</style>
</head>
<body>
	<div class="container">
		<a href="insertPage.jsp">새 글 작성하기</a>
		<a href="../index.jsp">LOGO</a>
		<br><hr><br>
		<%
			//개별 게시글 보기가 끝나면(목록으로 보기를 눌렀을 때) session에서 지우기
			if (session.getAttribute("boardDTO") != null) {
				session.removeAttribute("boardDTO");
			}

			
			List<BoardDTO> list = BoardDAO.getInstance().selectAll();
			pageContext.setAttribute("list", list);						//EL로 쓰기 위해
		%>
		<table>
			<thead>
				<tr>
					<th>게시글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="dto" items="${list}">
						<tr>
							<td>${dto.idx}</td>
							<td><a href="view.jsp?idx=${dto.idx}">${dto.title}</a></td>		<!-- pk인 idx를 전달해주는 a링크 -->
							<td>${dto.author}</td>
							<td>${dto.hit}</td>
							<td>${dto.postdate}</td>
						</tr>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>