package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.ModelAndView;
import dao.MemberDAO;
import dto.Member;

public class DeleteMemberCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Long no = Long.parseLong(request.getParameter("no"));
		
		int result = MemberDAO.getInstance().deleteMember(no);
		
		if(result > 0) {
			request.getSession().invalidate();	//세션에서 제거
		}
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		response.setContentType("applicaion/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		return null;
	}

}
