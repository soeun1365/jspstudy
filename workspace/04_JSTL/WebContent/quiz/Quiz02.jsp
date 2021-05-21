<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="Quiz02_2.jsp" method="get">
		<h3>일반 forEach 연습</h3>
		아래에 크기를 입력하면 폰트 크기를 확인할 수 있습니다.<br>
		최소크기 <input type="number" min="1" max="7" name="min" size="4"><br>
		최대크기 <input type="number" min="1" max="7" name="max" size="4">
		<br><br>
		<h3>향상 forEach 연습</h3>
		<label for="불고기"><input type="checkbox" name="foods" id="불고기" value="불고기">불고기</label>
		<label for="닭갈비"><input type="checkbox" name="foods" id="닭갈비" value="닭갈비">닭갈비</label>
		<label for="순대국"><input type="checkbox" name="foods" id="순대국" value="순대국">순대국</label>
		<label for="자장면"><input type="checkbox" name="foods" id="자장면" value="자장면">자장면</label>
		<label for="해장국"><input type="checkbox" name="foods" id="해장국" value="해장국">해장국</label>
		<br><br>
		<button>전송</button>
		<input type="reset" value="취소">
	</form>
</body>
</html>