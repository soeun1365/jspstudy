<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
</head>
<body>
	
	<form action="/12_AJAX/login.do" method="post">
		<input type="text" name="id" placeholder="ID"><br>
		<input type="password" name="pw" placeholder="Password"><br>
		<button>로그인</button>
		
		<a href="/12_AJAX/joinPage.do">회원가입</a>
	</form>
	
</body>
</html>