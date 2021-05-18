package login.captcha;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;

/**
 * Http://localhost:9090/03CAPTCHA/Login에 의해서 여기로 온다
 */
@WebServlet("/Login")	//URL 매핑값
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		1. 네이버에 캡차 키 요청하기
		2. 네이버에 캡차 이미지 요청하기
		3. 로그인 페이지에 캡차 이미지를 띄워서 로그인 페이지(Login.jsp)로 이동
*/
		// 	1. 네이버에 캡차 키 요청하기
		String key = CaptchaKey.getCaptchaKey();
		//확인코드 : response.getWriter().write(key);
		
		//Login.java -> LoginValidation.java 	key 전달하기
		// 1. request이용
		// Login.java -> login.jsp -> LoginValadation.java
		// request.setAttribute("key", key);
		//		<input type="hidden" name="key" value="<%=request.getAttribute("key")%>">
		//					request.getParameter("key")
		// 2. session이용 - 브라우저 종료전까지 살아있음, request처럼 중간에 전달할 필요가 없음
		// Login.java -> login.jsp ->LoginValaidation.java
		// session.setAttribute("key", key);
		//				session.getAttribute("key");
		//						session.getAttribute("key");
		
		//session구하는법 (java에서만) - (requestf 를 jsp에서 하는듯이)
		// 1. request에서 구한다.
		// 2. HttpSession session = request.getSession();
		HttpSession session = request.getSession();
		session.setAttribute("key", key);	//LoginValidation.java에서 필요함
		
		// 	2. 네이버에 캡차 이미지 요청하기
		CaptchaImage.getChptchaImage(request, key);
		// CaptchaImage.java에게 request를 전달하고,
		// CaptchaImage.java가 그 request에 데이터를 저장했다.
		// 따라서 request에 저장되어있는 데이터를 꺼내서 사용할 수 있다.
		//확인코드: String dir = (String)request.getAttribute("DIR");
		//확인코드: String filename = (String)request.getAttribute("filename");
		//확인코드: response.getWriter().write(dir + "/" + filename);
		
		// 	3. 로그인 페이지에 캡차 이미지를 띄우서 로그인 페이지(Login.jsp)로 이동
		//"캡차 이미지가 저장된 디렉터리 + 캡차 이미지 파일명"을 가지고 Login.jsp로 가야함
		//즉, request의 정보를 유지한 상태로 이동한다. -> forward
		request.getRequestDispatcher("Login.jsp").forward(request, response);
		

	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
