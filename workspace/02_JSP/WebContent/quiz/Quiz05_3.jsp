<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
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

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	String filename = id + ".txt";
	
	//파일이 저장될 경로 (realPath 활용)
	String realPath = application.getRealPath("quiz/" + filename);
	
	//파일 생성
	File file = new File(realPath);
	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	bw.write("가입아이디: " + id + "\n");
	bw.write("가입비밀번호: " + pw + "\n");
	bw.write("가입성명: " + name + "\n");
	if(bw != null){
		bw.close();
	}
	
%>
<script>
	function fn(){
		alert('탈퇴되었습니다.');
	}
</script>

	<h1>가입되었습니다.</h1>
	<h3>가입내용</h3><br>
	가입 아이디: <%=id%><br>
	가입 비밀번호: <%=pw%><br>
	가입 성명: <%=name%><br><br>
	<button onclick="fn">탈퇴</button>
</body>
</html>