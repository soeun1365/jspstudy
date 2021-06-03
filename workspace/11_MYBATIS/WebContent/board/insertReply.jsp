<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/11_MYBATIS/insertReply.do" method="post">
		<h3>댓글 작성하기</h3>
		<%-- 원글의 그룹번호 groupno --%>
		<input type="hidden" name="groupno" value="${param.groupno}">	<!-- 파라미터로 넘어온거라 param.groupno해야함 -->
		<p>작성자</p>
		<div><input type="text" name="author" autofocus></div>
		<p>제목</p>
		<div><input type="text" name="title" required></div>	<!-- required는 필수로 입력 -->
		<p>내용</p>
		<div><textarea name="content" rows="5" cols="80"></textarea></div>
		
		<button>저장하기</button>
		<input type="reset" value="작성초기화">
	</form>
</body>
</html>