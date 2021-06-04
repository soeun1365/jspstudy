<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<style>
		*{
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		label{
			display: block;
			font-weight: 700;
		}
		input{
			width: 250px;
			height: 50px;
			border: 1px solid gray;
			outline: none;
			padding: 5px 10px;
		}
		
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		//페이지 로드 이벤트
		$(document).ready(function(){
			//DOM 선언
			const join_form = $('#join_form');
			const id = $('#id');
			const id_msg = $('#id_msg');
			const join_btn = $('#join_btn');
			//결과
			idCheck();
			
			//이벤트
			id.blur(function(){
				idResult = idCheck();
			})
			join_btn.click(function(){
				join();
			})
			
		//함수
		function idCheck(){
			//반환
			let result = false;
			//아이디 정규식: 4자~32자, 소문자, 숫자, 특수문자(_,-), 시작은 소문자
			const regID = /^[a-z][a-z0-9_-]{3,21}$/;
			
			if( regID.test(id.val()) ){	//입력된 ID의 정규식 검사
				id_msg.text('검사통과');	//통과하면 database갔다온 코드가 와서 중복데이터인지 확인
					
				//데이터(id)를 보내고 바로 사용가능 여부를 이곳으로 받는 AJAX 비동기 통신
				$.ajax({
					url: '/12_AJAX/idCheck.do',		//서버 요청경로
					type: 'post',					//요청방식
					data: 'id=' + id.val(),			//파라미터 id를 보내기 //보내고자 하는 데이타(json로 보내기 가능(받는측에서 jsonparsing해야함), parameter로 보내기 가능)
					dataType: 'json',	//서버가 보내준 응답 데이터의 타입
					success: function(obj){
						// obj : {"result": true}또는{"result": false}
						// obj.result , obj["result"] 둘중 하나의 방법으로 값 꺼내기
						 if(obj.result){
							 id_msg.text('멋진 아이디네요~');
							 result = true;
						 } else{
							 id_msg.text('이미 가입된 아이디입니다.');
						 }
					},	//서버와 통신성공
					error: function(){
					alert('오류가 발생했습니다.');
					}
				})
					
				} else{
					id_msg.text('4자~32자, 소문자, 숫자, 특수문자(_,-), 시작은 소문자');
				}
			
			return result;
			
			}
			
			function join(){
				$.ajax({
					url: '/12_AJAX/join.do',
					type: 'post',
					data: join_form.serialize(),	//join_form 의 모든 파라미터를 보낼 때 쓴다.
					dataType: 'json',
					success: function(obj){
						if ( obj.result ){
							alert('회원가입 되었습니다.');
							location.href = '/12_AJAX/loginPage.do';
						}
					}
				})
			}
		})
	</script>
</head>
<body>
	<form id="join_form" method="post">
	
		<h1>회원가입</h1>
		
		<label for ="id">아이디</label>
		<input type="text" id="id" name="id">
		<div id="id_msg"></div>
		
		<label for ="pw">비밀번호</label>
		<input type="password" id="pw" name="pw">
		<div id="pw_msg"></div>
		
		<label for ="name">이름</label>
		<input type="text" id="name" name="name">
		<div id="name_msg"></div>
		
		<label for ="email">이메일</label>
		<input type="text" id="email" name="email">
		<div id="email_msg"></div>
		
		<label for ="phone">전화번호</label>
		<input type="text" id="phone" name="phone">
		<div id="phone_msg"></div>
		
		<input type="button" value="가입하기" id="join_btn">
	</form>
</body>
</html>