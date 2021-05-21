package model;

import javax.servlet.http.HttpServletRequest;

public class GugudanService {
	public String execute(HttpServletRequest request) {
		String strDan = request.getParameter("dan");
		int dan = 1;
		if (!strDan.isEmpty()) {
			dan = Integer.parseInt(strDan);
		}
		StringBuilder sb = new StringBuilder();//string 보다 빠른 sb처리
		for(int n = 1 ; n <= 9 ; n++) {
			sb.append(dan).append("x").append(n).append("=").append(dan*n).append("<br>");
		}
		request.setAttribute("gugudan", sb.toString()); //sb했던거 string으로 형변환 해줘야함
		return "views/output.jsp";
	}
}
