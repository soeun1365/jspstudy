<%@page import="dto.PageVO"%>
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

			// 1. pageVO 객체 생성
			PageVO pageVO = new PageVO();
			
			// 2. 전체 레코드의 개수 구하기
			int totalRecord = BoardDAO.getInstance().getTotalRecord();
			pageVO.setTotalRecord(totalRecord);
			
			// 3. 전체 페이지의 개수 구하는 setTotalPage()메소드 호출
			pageVO.setTotalPage();
			
			// 4. 파라미터 처리 (현재 페이지 번호)
			//	  1) page가 안넘어오면 page가 = 1 처리
			//	  2) page가 넘어오면 넘오온 page로 처리
			String strPage = request.getParameter("page");
			if (strPage != null) {
				pageVO.setPage(Integer.parseInt(strPage));
			}
			
			// 5. 현재 페이지 번호를 이용해 시작 게시글 번호와 종료 게시글 번호 구하기
			/************ 예시 ************
				1. 전체 11개 게시글이 있다.
				2. 한페이지에 3개의 게시글을 표시한다.
				
				page = 1, beginRecord = 1, endRecord = 3
				page = 2, beginRecord = 4, endRecord = 6
				page = 3, beginRecord = 7, endRecord = 9
				page = 4, beginRecore = 10, endRecord = 11 ( 판 페이지가 최대 3개 이지만 다 안채운채 나옴 )
				
			*******************************/
			//시작게시글 번호 = (현재페이지번호 - 1 )* 페이지당레코드 수 + 1
			int beginRecord = (pageVO.getPage() -1) * pageVO.getRecordPerPage() + 1 ;
			pageVO.setBeginPage(beginRecord);
			//종료레코드 번호 = 시작게시글 번호 + 페이지당레고드 수 - 1
			//단, 종료게시글번호와 전체게시글수 중 작은 값을 종료게시글 번호로 사용한다.
			int endRecord = beginRecord + pageVO.getRecordPerPage() - 1;
			endRecord = (endRecord < totalRecord ) ? endRecord : totalRecord;
			pageVO.setEndRecord(endRecord);
			
			// 6. 블록당 시작페이지, 종료 페이지 구하기
			/************ 예시 ************
				1. 전체 12개 게시글이 있다.
				2. 한 블록에 3개의 페이지를 표시한다.
				
				page = 1~5, beginPage = 1, endPage = 5
				page = 6~10, beginPage = 6, endPage = 10
				page = 11~15, beginPage = 11, endPage = 12
				
			*******************************/
			//시작페이지번호 = ((현재페이지번호 -1) / 블록당페이지수) * 블록당페이지수 + 1
			int beginPage = ((pageVO.getPage() - 1) / pageVO.getPagePerBlock() ) * pageVO.getPagePerBlock() + 1;
			pageVO.setBeginPage(beginPage);
			//종료페이지번호 = 시작페이지번호 + 블록당페이지수 - 1
			//단, 종료페이지번호와 전체 페이지 수 중 작은 값을 종료페이지번호로 사용한다.
			int endPage = pageVO.getBeginPage() + pageVO.getPagePerBlock() - 1;
			endPage = ( endPage < pageVO.getTotalPage() ) ? endPage: pageVO.getTotalPage();
			pageVO.setEndPage(endPage);
			
			//beginRecord 부터 endRecord 사이의 목록만 가져오기
			
			
			List<BoardDTO> list = BoardDAO.getInstance().selectAll(pageVO);
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