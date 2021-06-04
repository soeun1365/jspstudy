package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import common.ModelAndView;
import dao.MemberDAO;

public class IdCheckCommand implements MemberCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String id = request.getParameter("id");
			
			//사용가능 ID: result = true
			boolean result = MemberDAO.getInstance().idCheck(id);
			
			//응답 데이터를 JSON데이터 타입으로 생성
			JSONObject obj = new JSONObject();
			obj.put("result", result);	//jonn데이터 obj에는 {"result": true}또는 {"result" : false}이렇게 들어간다.
			
			//응답데이터를 곧바로 응답처리
			response.setContentType("application/json; charset=utf-8"); 		//JSON 데이터의 ContentType
			PrintWriter out = response.getWriter();
			out.println(obj);	//json데이터의 응답
			out.close();
			
			//controller로 ModelAndView를 반환하지 않아야만 redirect, forward 되지 않는다. 그래서 null값을 반환해야한다.(mav에서 null이면 redifect, forward이동하니까)
		return null;
	}

}
