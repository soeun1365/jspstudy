package command;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.PersonDAO;
import dto.Person;

@WebServlet("/insertPerson.do")
public class InsertPersonCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertPersonCommand() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			
			String sno = request.getParameter("sno");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			if(age < 0 || age > 100) {	//유효범위를 벗어난 나이 입력
				throw new RuntimeException();	//예외의 강제 발생
			}
			String birthday = request.getParameter("birthday");
			
			Person p = new Person();
			p.setSno(sno);
			p.setName(name);
			p.setAge(age);
			p.setBirthday(birthday);
			
			int count = PersonDAO.getInstance().insertPerson(p);
			JSONObject obj = new JSONObject();
			obj.put("count", count);	//만든 obj를 응답시켜줘야함
			
			response.getWriter().println(obj);
		}catch(NumberFormatException e) {
			//나이에 정수이외의 값이 입력되서 생긴 오류 이거는 자동으로 던져진것
			response.setStatus(3001);	//에러 코드 값을 작성, xhr.status를 통해서 확인 할 수 있다.
			response.getWriter().println("나이는 정수만 입력 가능합니다.");
		}catch(RuntimeException e) {
			//나이에 위에 설정해둔 유효범위를 벗어난 값이 입력되서 생긴 오류
			response.setStatus(3002);
			response.getWriter().println("나이는 0~100사이만 입력 가능합니다.");
		}catch(SQLException e) {
			//이름, 생일 에 칼럼의 길이보다 긴 값이 입력되서 생긴 오류
			response.setStatus(3003);
			response.getWriter().println("입력 데이터를 확인하세요.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
