package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class InsertReplyCommand3 implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1단 댓글달기
		
		//파라미터
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		long groupno = Long.parseLong(request.getParameter("groupno"));	// 게시글의 번호도 알아야해서 selectList.jsp에서 파라미터로 no값을 보내줌
		
		//DTO
		BoardDTO replyDTO = new BoardDTO();
		replyDTO.setAuthor(author);
		replyDTO.setTitle(title);
		replyDTO.setContent(content);
		replyDTO.setIp(ip);
		replyDTO.setGroupno(groupno);		// 댓글은 원글의no를 가져와 같은 그룹이 된다.
		replyDTO.setDepth(1);	// 1단 댓글달기 원글의 depth는 0이니 그거보다 하나 크게 1로 지정해주기
		replyDTO.setDepth(1); 	// 댓글의 depth는 1이다.
		replyDTO.setGroupord(1); // 그룹 내부 순서는 1을 가진다.
		
		//원글 정보 가져오기(dao 작업)
		
		//같은 그룹의 기존 댓글들 중에서
		//groupord가 가져온 원글(부모)의 groupord보다 큰 댓글들의 
		//groupord를 1씩 증가
		
		
		
		//기존 댓글들의 groupord를 모두 1씩 증가시킨다.
		BoardDAO.getInstance().increaseGroupordPreviousReply(groupno); // 그룹번호(groupno) 전달
		
		// DAO 댓글 삽입하기
		int result = BoardDAO.getInstance().insertReply(replyDTO);
		
		//이동 redirect
		return new ModelAndView("/11_MYBATIS/board/insertReplyResult3.jsp?result=" + result, true);// 삽입 후에는 반드시 리다이렉트한다.
	}

}
