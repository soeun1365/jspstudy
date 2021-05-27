<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<style>
		.container {
			width: 500px;
			margin: 100px auto;
			text-align: center;
		}
		a{
			text-decoration: none;
			color: black;
		}
		.container > a:nth-child(1){
			float: right;
		}
		h1{
			margin-bottom: 50px;
		}
	</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		const f = $('#f');
		const id = $('#id');
		const pw = $('#pw');
		f.on('submit', function(event){
			if (id.val() == '' || pw.val() == '') {
				alert('아이디와 비밀번호를 모두 입력하세요.');
				event.preventDefault();
				return false;
			}
		})
		
	})
</script>
</head>
<body>
	<div class="container">
		<a href="../index.jsp">LOGO</a>
		<form id="f" action="login.jsp" method="post">
			<h1>로그인 하기</h1>
			<input type="text" name="id" id="id" placeholder="아이디"><br>
			<input type="password" name="pw" id="pw" placeholder="비밀번호"><br><br>
			<button>로그인</button>
		</form>
	</div>
</body>
</html>