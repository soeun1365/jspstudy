<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<form action="/02_JSP/quiz/Quiz03_3.jsp">
		<h3>2. 좋아하는 운동선수는 누구인가요?</h3>
		<input type="text" name=player placeholder="운동선수 이름">
		<input type="hidden" name="username" value="<%=request.getParameter("username")%>">
		<input type="hidden" name="entertainer" value="<%=request.getParameter("entertainer")%>">
		<!-- username과 entertainer는 hidden으로 숨겨서 전달됨 -->
		<button>결과보기</button>
	</form>
</body>

</html>