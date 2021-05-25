<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index</title>
	<style>
		a{
			text-decoration: none;
			color: black;
		}
		.container {
			width: 500px;
			margin: auto;
			text-align: center;
			display: flex;
			justify-content: space-between;
		}
		.btn {
			width: 150px;
			height: 50px;
		}
		.btn > a {
			display: block;
			width: 100%;
			height: 100%;
			line-height: 50px;
		}
	</style>
</head>
<body>
	<h1 style="text-align: center">회원관리</h1>
	<div class="container">
		<div class="btn">
		<c:if test="${loginDTO == null}">
			<a href="/09_MODEL1/member/joinPage.jsp">회원가입</a>	<!-- 로그인 하지 않았을 때 회원가입 보임 -->
		</c:if>
		<c:if test="${loginDTO != null}">
			<a href="/09_MODEL1/board/boardList.jsp">게시판</a>	<!-- 로그인을 하면 회원가입을 막고, 게시판을 볼 수 있음 -->
		</c:if>	
		</div>
		<div class="btn">
			<c:if test="${loginDTO eq null}">
					<a href="/09_MODEL1/member/loginPage.jsp">로그인</a>	
			</c:if>
			<c:if test="${loginDTO ne null}">
				${loginDTO.name}님<br> 반갑습니다.<br>
				<a href="/09_MODEL1/member/logout.jsp">로그아웃</a>
				<a href="/09_MODEL1/member/myPage.jsp">개인정보 보기</a>
				<c:if test="${loginDTO.id eq 'admin'}">
					<a href="/09_MODEL1/member/memberList.jsp">회원목록보기</a>	<!-- 관리자로 로그인 시 보이는 항목 -->
				</c:if>
			</c:if>
		</div>	
	</div>
</body>
</html>