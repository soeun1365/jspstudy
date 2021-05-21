<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
	
		onload = function(){
			document.getElementById('btn1').onclick = function(){
				locatin.href = '/05_MVC/DateController';
			}
			
			document.getElementById('btn2').onclick = function(){
				locatin.href = '/05_MVC/TimeController';
			}
			
			document.getElementById('btn3').onclick = function(){
				locatin.href = '/05_MVC/LottoController';
			}
		}
	</script>
	
</head>
<body>
	<%-- VIEW : 언제나 Servlet(Controller)에게 요청한다. --%>
	<input type="button" value="현재날짜를 알려다오" id="btn1">
	<input type="button" value="지금 시간을 알려다오" id="btn2">
	<input type="button" value="로또 번호 6개를 알려다오" id="btn3">
	
	<form action="/05_MVC/GugudanController">
		<input type="number" min="2" max="9" placeholder="원하는 구구단 입력">
		<button>구구단을 보여주세요</button>
	</form>
	<a href="/05_MVC/AgeController?age=10">맥주주세요</a>
	<form id="f">
		<h3>밥 주세요.</h3>
		<input type="text" name="hour" placeholder="지금 시간을 입력하세요.">
		<input type="button" value="밥주세요" id="btn4">
	</form>
	
	<script>
		const form = document.getElementById('f');	//const form = #('f')
		document.getElementById('btn4').addEventListener('click', function(){
			if(from.hour.value = ''){
				alert('지금 시간을 꼭 입력하세요.');
				form.hour.focus();
				return;	//함수를 끝냄
			}
			form.action = '/05_MVC/MealController';
			form.submit();	//일반 버튼을 썼기 때문에 submit함수호출을 해야함
		})
		
		
	</script>
</body>
</html>