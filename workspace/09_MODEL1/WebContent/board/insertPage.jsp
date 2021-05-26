<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>새 글 작성하기</title>
	<style>
		.container{
			width: 500px;
			margin: 100px auto;
		}
		h1{
			text-align: center;
		}
		label{
			display:inline-block;
			width: 100px;
		}
		input[type="text"], textarea{
			width: 100%;
		}
		textarea{
			height: 100px;
		}
		p{
			text-align: center;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		//페이지 로드 이벤트
		$(function(){
			
			const f = $('#f');
			const title = $('#title');
			const author = $('#author');
			f.submit(function(event){
				if (author.val() == '') {
					alert('비정상적인 접근입니다.');	//작성자가 없는경우(주소로 바로 들어온경우 등..)
					history.back();
					return false;
				} else if(title.val() == '') {
					alert('제목은 필수입니다.');
					title.focus();
					event.preventDefault();
					return false;
				}
			})
		})
	</script>
</head>
<body>
	<div class="container">
		<h1>게시글 작성하기</h1>
		<form action="insertBoard.jsp" id="f" method="post">
			<label>작성자</label><input type="text" id="author" name="author" value="${loginDTO.id}" readonly><br>	
					<!-- readonly를 쓰면 수정이 안됨 // 외래키인 name을 EL을 사용해서 찍어준다 -->
					<!-- 로그인해야만 board가 보인다는것도 알기 -->
			<label>제목</label><input type="text" name="title" id="title" autofocus><br><br>	<!-- 자동으로 커서 옮겨주는 포커싱 -->
			<!-- 제목은 pk라서 notnull -->
			<textarea name=content placeholder="내용을 입력하세요"></textarea><br>
			
			<p>
			<button>작성하기</button>
			<input type="reset" value="작성초기화">
			<input type="button" value="게시판으로 이동" onclick="location.href='boardList.jsp'">
			</p>
		</form>
	</div>
</body>
</html>