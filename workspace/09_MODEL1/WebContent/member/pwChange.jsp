<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 파라미터 처리
	request.setCharacterEncoding("utf-8");
	String pw = request.getParameter("pw");
	
	// 2. DB로 보낼 DTO 생성
	MemberDTO dto = new MemberDTO();
	dto.setPw(pw);
	dto.setNo( ((MemberDTO)session.getAttribute("loginDTO")).getNo() );
		// PK도 같이 알려줘야 누구의 비번 변경하는건지 알 수 있음
		// session에 저장되있는거 꺼내기
	
	//3. DAO의 updatePw() 메소드 호출
	int result = MemberDAO.getInstance().updatePw(dto);
	
	// 4. 결과
	if (result > 0) {	// 수정된 건이 있다. (result == 1)해도됨 오직 하나의 사람정보만 수정되니까
		//비밀번호 변경 성공했을 때
		//session의 비밀번호 갱신
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginDTO");
		loginDTO.setPw(pw);
		out.println("<script>");
		out.println("alert('비밀번호가 수정되었습니다.')");
		out.println("location.href='myPage.jsp'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('비밀번호가 수정되지 않았습니다.')");
		out.println("history.back()");
		out.println("</script>");
	}
%>