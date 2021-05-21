package model;

import javax.servlet.http.HttpServletRequest;

public class BeerService {
	public String exeute(HttpServletRequest request) {
		int age = 0;
		try {
			age = Integer.parseInt(request.getParameter("age"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("result", age < 20 ? "아가는 포카리나 드세요" : "여기있습니다.");
		return "views/output.jsp";
	}
}
