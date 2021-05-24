package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class AverageCommand implements ScoreCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int kor = 0;
		int eng = 0;
		int mat = 0;
		double average = 0.0;
		
		try {
			kor = Integer.parseInt(request.getParameter("kor"));
			eng = Integer.parseInt(request.getParameter("eng"));
			mat = Integer.parseInt(request.getParameter("kor"));
			
			average = ( kor + eng + mat ) / 3;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("views/output.jsp", false);
	}

}
