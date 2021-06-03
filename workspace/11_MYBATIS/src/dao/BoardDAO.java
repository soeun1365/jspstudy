package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.ModelAndView;
import dto.BoardDTO;
import mybatis.config.DBService;

public class BoardDAO {
	
	private SqlSessionFactory factory;
	
	//싱글톤
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {
		factory = DBService.getInstance().getfactory();	//DBService를 사용해서 factory를 받아온다
	}
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	
	final String NAMESPACE = "mybatis.mapper.board";
	
	
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
	
	/* 4. 같은 그룹의 기존 댓글들의 groupord 1증가 */
	public int increaseGroupordPreviousReply(long groupno) {	//반환타입 있어도 되고 없어도 되고 일단 int로 하겠다
		SqlSession ss = factory.openSession(false);	// 직접 커밋하겠다.
		int result = ss.update("mybatis.mapper.board.increaseGroupordPreviousReply", groupno);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	/* 5. 댓글 삽입하기 */
	public int insertReply(BoardDTO replyDTO) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(NAMESPACE + ".insertReply", replyDTO);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	/* 6. 검색 결과 개수 반환 */
	public int getFindRecordCount(Map<String, Object> map) {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(NAMESPACE + ".getFindRecordCount", map);
		ss.close();
		return count;
	}
	
	/* 7. 검색 결과 반환 */
	public List<BoardDTO> findList(Map<String, Object> map) {
		SqlSession ss = factory.openSession();
		List<BoardDTO> list = ss.selectList(NAMESPACE + ".findList", map);
		ss.close();
		return list;
	}
	
	/* 8. 삭제 */
	public int delete(long no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(NAMESPACE + ".delete", no);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	/* 9. 대댓글목록 조회 */
	public List<BoardDTO> selectList3(Map<String, Integer> map){
		SqlSession ss = factory.openSession();
		List<BoardDTO> list = ss.selectList("mybatis.mapper.board.selectList3", map);
		ss.close();
		return list;
	}
}
