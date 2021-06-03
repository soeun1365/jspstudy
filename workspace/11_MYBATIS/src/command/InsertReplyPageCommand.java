package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class InsertReplyPageCommand implements BoardCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new ModelAndView("board/insertReply.jsp", false);	//포워드니까 request의 no가 전달이 되겠군~
	}

}
