package ex04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex04
 */
@WebServlet("/Ex04")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request의 캐릭터 셋 인코딩 처리 : UTF-8
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		if(name == null || name.isEmpty()) {	//기본값을 주기
			name = "기본이름";
		}
		System.out.println("이름: " + name);
		
		String strHeight = request.getParameter("height");
		int height = 0;
		if(strHeight != null && !strHeight.isEmpty()) {		//값이 있다면 형변환을 시켜주자
			height = Integer.parseInt(strHeight);
		}
		System.out.println("키: " + height + "cm");
		
		String strWeight = request.getParameter("weight");
		double weight = 0.0;
		if (strWeight != null && !strWeight.isEmpty()) {		//값이 있다면 형변환을 시켜주자
			weight = Double.parseDouble(strWeight);
		}
		System.out.println("몸무게: " +  weight + "kg");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 호출");	//doPost()들렸다 오는지 확인
		doGet(request, response);
	}

}
