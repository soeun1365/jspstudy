<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/02_JSP/quiz/Quiz05_2.jsp" method="post">
		<h3>신규 회원 정보를 입력하세요</h3>
		아이디&emsp;&emsp;&emsp;<input type="text" name="id"><br>
		비밀번호&emsp;&emsp;<input type="password" name="pw"><br>
		이름&emsp;&emsp;&emsp;&emsp;<input type="text" name="name"><br>
		<input type="submit" value="회원가입">	<!-- type="submit"도 같은역할을함 -->
	</form>
</body>
</html>