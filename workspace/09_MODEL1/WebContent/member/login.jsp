<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 처리
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 2. DB로 보낼 DTO 생성
	MemberDTO dto = new MemberDTO();
	dto.setId(id);
	dto.setPw(pw);
	
	// 3. 만든dto를 DAO로 보내기
	// DAO의 login()메소드 호출
	MemberDTO loginDTO = MemberDAO.getInstance().login(dto);
	
	// 4. 로그인이 되었다면 loginDTO(로그인된 회원정보)를 session에 올린다.
	if(loginDTO != null){
		session.setAttribute("loginDTO", loginDTO);
		response.sendRedirect("/09_MODEL1/index.jsp");
	} else {
		out.println("<script>");
		out.println("alert('회원 정보를 확인하세요')");
		out.println("history.back()");
		out.println("</script>");
	}
	
%>