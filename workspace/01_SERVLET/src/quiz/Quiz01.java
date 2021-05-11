package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz
 */
@WebServlet("/Quiz01")
public class Quiz01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd");
		
		Calendar calendar = Calendar.getInstance();
		String message = "";
		switch(cmd) {
			case "date" :
				int year = calendar.get(calendar.YEAR);
				int month = calendar.get(calendar.MONTH) + 1;
				int date = calendar.get(calendar.DATE);
				message = year + "년 " + month + "월 " + date + "일 ";
				break;
			case "time" : 
				int hour = calendar.get(calendar.HOUR);
				int minute = calendar.get(calendar.MINUTE);
				int second = calendar.get(calendar.SECOND);
				message = hour + "시 " + minute + "분 " + second + "초";
				break;
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<script>");
		out.println("alert(' "+ message + "')");
		out.println("history.back()");	//history.go(-1) 이것도 같은 의미임
		out.println("</script>");
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
