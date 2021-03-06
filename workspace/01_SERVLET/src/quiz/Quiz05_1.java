package quiz;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz05_1
 */
@WebServlet("/Quiz05_1")
public class Quiz05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz05_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//리다이렉트는 기존 request정보를 전달하지 않는다.
		//따라서 우리가 직접 다시 전달한다.
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		//전달전 출력한번해보기
		System.out.println(name + ", " + age);
		
		response.sendRedirect("/01_SERVLET/Quiz05_2?name=" + URLEncoder.encode(name, "utf-8") +"&age=" + age);		//새로운 request에 새로운 파라미터로 직접 전달해주기, 한글은 직접 인코딩
		
		//인코딩(암호화) : URLEncoder.encode("문자열", "utf-8")
		//디코딩(복호화) : URLDecoder.decode("문자열", "utf-8")
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
