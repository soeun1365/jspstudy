package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PersonDAO;
import dto.Person;

@WebServlet("/selectPersonList.do")
public class SelectPersonListCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectPersonListCommand() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> list = PersonDAO.getInstance().selectPersonList();
		JSONArray arr = new JSONArray();
		//list(에 들어있는것을 하나씩 빼면) -> Person (Proson을 JsonObject로 바꿔) -> array
		for(Person person : list) {
			JSONObject obj = new JSONObject();
			obj.put("sno", person.getSno());
			obj.put("name", person.getName());
			obj.put("age", person.getAge()+"");				// 가입일자SYSDATE에 빈문자열 더해서 문자열로 바꿔주기 or xxx.toString()
			obj.put("birthday", person.getBirthday());
			obj.put("regdate", person.getRegdate() + "");	// 가입일자SYSDATE에 빈문자열 더해서 문자열로 바꿔주기 or xxx.toString()
			arr.add(obj);
		}
		//System.out.println(arr);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(arr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
