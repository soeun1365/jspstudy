<%@page import="java.net.URLEncoder"%>
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

	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	Cookie cookie1 = new Cookie(address, URLEncoder.encode(address, "utf-8"));
	cookie1.setMaxAge(60*60);
	response.addCookie(cookie1);
	Cookie cookie2 = new Cookie(phone, URLEncoder.encode(phone, "utf-8"));
	cookie1.setMaxAge(60*60);
	response.addCookie(cookie2);
	Cookie cookie3 = new Cookie(email, URLEncoder.encode(email, "utf-8"));
	cookie1.setMaxAge(60*60);
	response.addCookie(cookie3);
%>
	<h3>추가정보를 입력하세요.</h3>
	<form action="/02_JSP/quiz/Quiz06_4.jsp" method="post">
		생년월일&emsp;	<input type="text" name="year" size="4">년 
						<input type="text" name="month" size="4">월 
						<input type="text" name="day" size="4">일<br>
		결혼여부&emsp;	<label><input type="radio" name="marriage" value="미혼" id="marrie_n"> 미혼</label>
						<label><input type="radio" name="marriage" value="기혼" id="marrie_y"> 기혼</label><br>
		직업&emsp;&emsp;&emsp;	<select name="job">
									<option value="student">학생</option>
									<option value="banker">은행원</option>
									<option value="teacher">선생님</option>
								</select><br><br>	
		<button>확인</button>
	</form>
</body>
</html>