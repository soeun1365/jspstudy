package mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//역할: SqlSessionFactory를 빌드해서 DAO에게 넘겨준다.
public class DBService {
	
	//싱글톤작업
	private static DBService instance = new DBService();
	private SqlSessionFactory factory;
	
	private DBService() {
		//SqlSessionFactory 빌드
		try {	//아래 세줄은 mybatis.org에 나와있는거 붙여쓰기 한것
			String resource = "mybatis/config/sqlmap-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBService getInstance() {
		if(instance == null) {
			instance = new DBService();
		}
		return instance;
	}
	
	public SqlSessionFactory getfactory() {
		return factory;
	}
	
}
