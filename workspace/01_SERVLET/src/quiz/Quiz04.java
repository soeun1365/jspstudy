package quiz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz03
 */
@WebServlet("/Quiz04")
public class Quiz04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		// IP주소
		// 1. 기본은 request.getRemoteAddr()로 알 수 있다.
		// 2. 거쳐서 온 IP는 X-Forwarded-For 요청 헤더(request header)에 있다.
		String ip = request.getHeader("X-Forwarded-For");
		if(ip == null) {	//거쳐오지않고 직접 왔다면 비어있음
			ip = request.getRemoteAddr();
		}
		
		// 작성일자
		String date = new SimpleDateFormat("yyyy-MM-dd H:mm:ss").format(new Date());	//형식을 갖추는 SimpleDateFormat에 newDate을 넣어준다.
		
		// 생성할 파일명
		String filename = date.substring(0, 10) + "_" + writer + ".txt" ;		//날짜10글자추출_작성자.txt
		
		// 파일 경로
		File file = new File("C:\\spring0303_ase\\jspstudy", filename);
		
		// 파일 생성 스트림
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		// 파일 생성
		bw.write("작성일자: " + date + '\n');	//줄바꿈까지 해주기		//bw.newLine();	줄바꿈 이렇게도 작성 가능
		bw.write("작성IP: " + ip + '\n');
		bw.write("작성자: " + writer + '\n');
		bw.write("제목: " + title + '\n');
		bw.write( contents );
		
		if(bw != null) {
			bw.close();			
		}

		//응답만들기
		response.setHeader("Content-Type", "text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println("alert('" + filename + "파일이 생성되었습니다.')");
		out.println("history.back()");
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
