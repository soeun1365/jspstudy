package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;

public class GradeCommand implements ScoreCommand {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String grade = "";
		int kor = 0;
		int eng = 0;
		int mat = 0;
		double average = 0.0;
		try {
			kor = Integer.parseInt(request.getParameter("kor"));
			eng = Integer.parseInt(request.getParameter("eng"));
			mat = Integer.parseInt(request.getParameter("kor"));
			average = ( kor + eng + mat ) / 3;
			if(average >= 90) {
				grade = "A";
			} else if(average >= 80) {
				grade = "B";
			} else if(average >= 70) {
				grade = "C";
			} else if(average >= 60) {
				grade = "D";
			} else {
				grade = "F";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("views/output.jsp", false);
	}

}
