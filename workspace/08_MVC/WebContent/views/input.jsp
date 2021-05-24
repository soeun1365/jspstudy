<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#btn1').on('click', function(){
				$('#f').submit();
			})
		})
	</script>
</head>
<body>
	<form action="/08_NVC/inquiry.do" id="f">
		<input type="text" name="kor" placeholder="국어점수">
		<input type="text" name="eng" placeholder="영어점수">
		<input type="text" name="mat" placeholder="수학점수">
		<button id = "btn1">성적조회</button>
	</form>
</body>
</html>