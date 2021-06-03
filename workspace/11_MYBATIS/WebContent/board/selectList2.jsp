<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.link{
			font-size: 8px;
			color: blue;
			text-decoration: none;
		}
		.link:hover{
			cursor: pointer;
		}
		table{
			border-collapse: collapse;
		}
		.insert_reply{
			display: none;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			
			// '답글'을 클릭하면 아래 insert_reply 클래스가 toggle 된다.
			/* 	
				<tr>
					<td>
						<a class="link">답글</a>
					</td>
				</tr>
				<tr class="insert_reply">
				</tr>
			*/
			const links = $('.link');	/* link는 클래스이고 for로 나오기 때문에 여러개라서 한개가 아님
											links. click();가 불가능 */
/*	제이쿼리 for문

			$.each(배열, function(인덱스, 요소){
			})
*/
			$.each(links, function(i, link){	//i, link는 변수
				$(link).click(function(){	//각 링크에 클릭 이벤트 변수 사용 가능 / 제이쿼리에서 변수를 부를떈 $()안에 따옴표 없이 변수명
					//$(this)는 여기서 $(link)의미
					$(this).parent().parent().next().toggleClass('insert_reply');
				})
			})
		})
	</script>
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
							<c:if test="${dto.state == 0}">
								<c:if test="${dto.depth == 1}">
								&nbsp;&nbsp;[re]
								</c:if>
								${dto.title}
								<c:if test="${dto.depth == 0}">
									<a class="link">답글</a>
								</c:if>
								<!-- 로그인DTO가 있을경우 할수있는 부분이다. (로그인했을경우 본인이 작성한댓글에는 삭제링크가 뜨게)
								<c:if test="${loginDTO.id == dto.author}">
									<a href="">삭제</a>
								</c:if>
								 -->
								 <a href="/11_MYBATIS/delete.do?no=${dto.no}">삭제</a>
							</c:if>
							<c:if test="${dto.state == -1}">
								삭제된 게시글 입니다.
							</c:if>
						</td>	
						<td>${dto.author}</td>
						<td>${dto.lastmodified}</td>
						<td>${dto.hit}</td>
					</tr>
					<tr class="insert_reply">
						<form action="/11_MYBATIS/insertReply2.do">
							<input type="hidden" name="groupno" value="${dto.groupno}">
							<td><input type="text" name="author" placeholder="작성자"></td>
							<td><input type="text" name="title" placeholder="제목"></td>
							<td><input type="text" name="content" placeholder="내용"></td>
							<td><button>작성</button></td>
							<td><input type="button" value="취소"></td>
						</form>
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