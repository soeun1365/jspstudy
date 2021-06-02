package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class InsertCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//파라미터
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		
		//DTO
		BoardDTO dto = new BoardDTO();
		dto.setAuthor(author);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setIp(ip);
		
		//DAO
		int result = BoardDAO.getInstance().insert(dto);
		
		// 결과를 처리할 insertResult.jsp를 만들고 이동한다
		
		return new ModelAndView("/11_MYBATIS/board/inserResult.jsp?result=" + result, true);	//삽입 후에는
	}

}
