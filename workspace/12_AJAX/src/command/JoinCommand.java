package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.ModelAndView;
import dao.MemberDAO;
import dto.Member;

public class JoinCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id  = request.getParameter("id");
		String pw  = request.getParameter("pw");
		String name  = request.getParameter("name");
		String email  = request.getParameter("email");
		String phone  = request.getParameter("phone");
		
		Member member = new Member(id, pw, name, email, phone);
		
		int result = MemberDAO.getInstance().join(member);
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		response.setContentType("appliication/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		return null;	//ajax처리하니까 null이어야한다!! 다른곳으로 이동x
	}
}
