package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeService implements HomeService{
	//TimeService도 타입이 두개이다.
	//TimeService, HomeService(상속받은것)
	
	@Override		/* 반드시 @override써줘야함 */
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
		request.setAttribute("time", sdf.format(date));
		return "views/output.jsp";
	}
}
