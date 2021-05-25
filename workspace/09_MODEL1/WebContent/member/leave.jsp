<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 탈퇴할 회원 번호
	long no = ((MemberDTO)session.getAttribute("loginDTO")).getNo();
	
	// 2. DAO의 deleteMember()메소드 ghcnf
	int result = MemberDAO.getInstance().deleteMember(no);
	
	// 3. 결과
	if(result > 0) {
		// session의 loginDO 제거
		session.invalidate();		//세션을 싹 지움
		out.println("<script>");
		out.println("alert('탈퇴되었습니다.')");
		out.println("location.href='../index.jsp'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('탈퇴되지 않았습니다.')");
		out.println("history.back()");
		out.println("</script>");
	}
%>