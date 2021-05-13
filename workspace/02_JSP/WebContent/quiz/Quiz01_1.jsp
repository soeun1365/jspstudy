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
		String[][] sites = {
				{"구글", "http://www.google.com"}	,
				{"네이버", "http://www.naver.com"},
				{"다음", "http://www.daum.net"},
				{"네이트", "http://www.nate.com"}
		};
	%>
	
	<%-- 
		<select name="sites">
			<option value="http://google.com">구글</option>
		</select>
		
	 이것을 아래처럼 java로 표현하자
	 --%>
	 
	<form action="/02_JSP/quiz/Quiz01_2.jsp">
		사이트명:
		<select name="site">
			<% for (int i = 0 ; i < sites.length ; i++) { %>
				<option value="<%=sites[i][1]%>"><%=sites[i][0]%></option>
			<% } %>
		</select>
		<button>확인</button>
	</form>
</body>
</html>