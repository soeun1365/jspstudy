package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import mybatis.config.DBService;

public class BoardDAO {
	
	private SqlSessionFactory factory;
	
	//싱글톤
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
		factory = DBService.getInstance().getfactory();
	}
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	/* 1. 게시글 작성 */
	public int insert(BoardDTO dto) {
		SqlSession ss = factory.openSession(false);	//insert 후 수동커밋하겠다.
		int result = ss.insert("mybatis.mapper.board.insertBoard", dto); 	//ss.insert("SQL's id", "인수");
		
		if(result > 0) {	//ss.insert()가 성공하면
			ss.commit();//수동커밋하겠다.
		}
		
		ss.close();
		return result;
	}
	
	/* 2. 전체 레코드 개수 조회 */
	public int getTotalRecord() {
		SqlSession ss = factory.openSession();	//커밋이 필요없는 SELECT문
		int count = ss.selectOne("mybatis.mapper.board.getTotalRecord");
		ss.close();
		return count;
	}
	
	/* 3. 목록 조회 */
	public List<BoardDTO> selectList(Map<String, Integer> map){
		SqlSession ss = factory.openSession();
		List<BoardDTO> list = ss.selectList("mybatis.mapper.board.selectList", map);
		ss.close();
		return list;
	}
}
