<%@page import="dao.BoardDAO"%>
<%@page import="dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	// 1. 파라미터 없음, boardDTO가 session에 올라가있음
	//	   session에서 boardDTO의 idx를 빼서 삭제할 게시글 번호 확인
	long idx = ((BoardDTO)session.getAttribute("boardDTO")).getIdx();
	
	// 2.  DAO의 deleteBoard() 메소드 호출
	int result = BoardDAO.getInstance().deleteBoard(idx);
	pageContext.setAttribute("result", result);				// EL사용을 위해
%>	
	<c:if test="${result eq 1}">
		<h1>게시글이 삭제되지 않았습니다.</h1>
		<a href="view.jsp?idx=<%=idx%>">게시글로 이동</a>
		<a href="boardList.jsp">게시판으로 이동</a>
	</c:if>

