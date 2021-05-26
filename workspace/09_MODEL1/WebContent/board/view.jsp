<%@page import="dto.MemberDTO"%>
<%@page import="dao.BoardDAO"%>
<%@page import="dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 보기</title>
	<style>
		*{
			font-family: '돋움', sans-serif;
			font-size: 16px;
		}
		.container{
			width: 500px;
			margin: 100px auto;
		}
		a{
			text-decoration: none;
			color: black;
		}
		.container > a:nth-child(1){
			float: right;
		}
	</style>
</head>
<body>
	<%
		// 1. 파라미터 처리
		request.setCharacterEncoding("utf-8");
		long idx = Long.parseLong(request.getParameter("idx"));
		 
		// 2. DAO의 updateHit() 메소드 호출
		//본인이 쓴 글이 아닐 경우에만 조회수 올라가도록
		
			// 로그인된 사용자: loginDTO
			String author1 = ((MemberDTO)session.getAttribute("loginDTO")).getId();
		
			// 게시글의 작성자: dto
			BoardDTO dto = BoardDAO.getInstance().selectByIdx(idx);
			String author2 = dto.getAuthor();
		
		// 3. DAO의 selectByIdx() 메소드 호출
		pageContext.setAttribute("dto", dto);					// EL사용을 위해
		if( !author1.equals(author2)){
			BoardDAO.getInstance().updateHit(idx);
			dto.setHit(dto.getHit() + 1);
		}
		// 4. session에 게시글 올리기
		session.setAttribute("boardDTO", dto);
		
	%>                                                                          
	
	<div class="container">
		<a href="../index.jsp">LOGO</a>
		<h3>게시글 번호</h3>
		${boardDTO.idx}<br><br>
		<h3>제목</h3>
		${boardDTO.title}<br><br>
		<h3>작성자</h3>
		${boardDTO.author}<br><br>
		<h3>조회수</h3>
		${boardDTO.hit}<br><br>
		<h3>작성일</h3>
		${boardDTO.postdate}<br><br>
		<h3>내용</h3>
		<pre>${boardDTO.content}</pre><br><br>
		
		<!-- 작성자는 수정하기/삭제하기를 할 수 있다. -->
		<c:if test="${loginDTO.id eq boardDTO.author}">
		<input type="button" value="수정하기" onclick="location.href='updatePage.jsp'">
		<input type="button" value="삭제하기" onclick="fn_delete()">
		</c:if>
		<input type="button" value="목록으로 이동" onclick="location.href='boardList.jsp'">
		
		<script>
			function fn_delete(){
				if (confirm('삭제할까요?')) {
					location.href= 'deleteBoard.jsp';
						//boardDTO가 session에 올라가 있음, 아니었으면 pk인 게시글번호를 넘겼어야한다.
				}
			}
		</script>
	</div>                                                                                      
</body>
</html>