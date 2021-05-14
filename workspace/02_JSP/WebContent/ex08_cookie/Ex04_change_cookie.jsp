<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%--
		쿠키를 변경하는 과정
		1. 서버가 클라이언트의 모든 쿠키를 읽어야 한다.
		2. 변경하고자 하는 쿠키를 찾아야한다.
		3. 같은 쿠키 이름을 가진 새로운 쿠키를 만들어주고 덮어쓰기한다.(addCookie)
	 --%>
	<%
		//1.쿠키이름이 "name"인 쿠키를 "초코", 1일간 유지로 변경하기
		Cookie ck = new Cookie("name", "초코");
		ck.setMaxAge(60*60*24);
		
		//2. 전체 쿠키를 읽는다.
		Cookie[] cookies = request.getCookies();
		
		//3. 같은 쿠키를 찾는다.
		if(cookies != null && cookies.length != 0){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("name")){
					response.addCookie(ck);	//덮어쓰기 하는 과정
				}
			}
		}
		
		//4. 다시 전체 쿠키를 확인해 본다.
		Cookie[] cookies2 = request.getCookies();
		if(cookies2 != null && cookies2.length != 0){
			for(Cookie cookie : cookies2){
				out.println("쿠키이름: " + cookie.getName()+"<br>");
				out.println("유효시간: " + cookie.getMaxAge()+"<br>");
				out.println("값: " + URLDecoder.decode(cookie.getValue(),"utf-8")+"<br>");
			}
		}
	%>
</body>
</html>