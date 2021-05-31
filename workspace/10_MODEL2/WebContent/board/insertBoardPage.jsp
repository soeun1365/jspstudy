<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:include page="../layout/header.jsp">
	<jsp:param value="게시글 작성" name="title" />
</jsp:include>

<link rel="stylesheet" href="../assets/css/layout.css">
<style>
	.insert_form{
		width: 300px;
		margin: 0 auto;
	}
	.title{
		display: inline;
	}
	#f input[type=text] {
		padding: 5px;
		width: 100%;
		height: 50px;
	}
	textarea{
		width:300px;
		height: 150px;
	}
	#f #insert_btn, #reset_btn, #list_btn {
		width: 30%;
		height: 50px;
		line-height: 50px;
		background-color: orange;
		border: none;
		font-weight: 700;
		font-size: 14px;
		color: white;
		cursor: pointer;
	}
	.title {
		font-weight: 700;
		font-size: 14px;
	}
</style>
<script>
	$(document).ready(function(){
		
		const f = $('#f');
		const title = $('#title');
		const insert_btn = $('#insert_btn');
		insert_btn.click(function(){
			if (title.val() == '') {
				alert('제목은 필수입니다.');
				title.focus();
				return;
			}
			f.attr('action', '/10_MODEL2/insertBoard.b');
			f.submit();
		})
		
		const list_btn = $('#list_btn');
		list_btn.click(function(){
			location.href = '/10_MODEL2/selectListBoardPage.b';
		})
		
	})
</script>
<div class="insert_form">
	
	<form method="post" id="f" enctype="multipart/form-data">
		<p class="title">작성자</p>
		<input type="text" id="author" name="author" value="${loginDTO.id}" readonly><br>
		<p class="title">제목</p>
		<input type="text" id="title"  name="title" autofocus><br>
		<p class="title">첨부</p>
		<input type="file" id="filename" name="filename">
		<p class="title">내용</p>
		<textarea id="content" name="content"></textarea><br><br>
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">	<!-- 숨겨서 ip를 넘겨준다 -->
		<input type="button" value="저장하기" id="insert_btn">
		<input type="reset" value="작성초기화" id="reset_btn">
		<input type="button" value="목록보기" id="list_btn">
	</form>
	
</div>

<%@ include file="../layout/footer.jsp" %>