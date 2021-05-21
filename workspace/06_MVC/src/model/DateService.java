package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateService implements HomeService{
		// DateService 클래스는
		// 타입이 두개이다
		// DataService, HomeService(상속받은것)

	@Override		/* 반드시 @override써줘야함 */	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("date", sdf.format(date));
		return "views/output.jsp";
	}
}
