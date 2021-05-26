package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.util.DBConnector;
import dto.BoardDTO;
import dto.PageVO;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	//싱글톤
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() {
		con = DBConnector.getInstance().getConnection();	//생성되면 접속
	}
	public static BoardDAO getInstance() {	//없으면 만들어라
		if(dao == null) {
			dao = new BoardDAO();	
		}
		return dao;
	}
	
	/* 1. 게시글 삽입 */
	public int insertBoard(BoardDTO dto) {
		int result = 0;
		try {
			sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setNString(1, dto.getAuthor());
			ps.setNString(2, dto.getTitle());
			ps.setNString(3, dto.getContent());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	
	
	/* 2. 일부 게시글 반환 */
	public List<BoardDTO> selectAll(PageVO pageVO) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			
			/*
			 select b.rn , b.employee_id, b.first_name
			  from (select rownum as rn, a.employee_id, a.first_name
			          from (select employee_id, first_name
			                  from employees
			                 order by hire_date) a) b
			 where b.rn between 11 and 20;              
			    
			-- 읽는 순서가 from/where/select이기 때문에 form 절에 as 이름 만들어줌                        
			-- a: 정렬한 테이블
			-- b: a 테이블에 rn을 추가한 테이블	
			 */

			sql = "select b.IDX, b.AUTHOR, b.TITLE, b.CONTENT, b.HIT, b.POSTDATE\r\n" + 
					"  from (select rownum as rn, a.IDX, a.AUTHOR, a.TITLE, a.CONTENT, a.HIT, a.POSTDATE\r\n" + 
					"          from (select IDX, AUTHOR, TITLE, CONTENT, HIT, POSTDATE\r\n" + 
					"                  from board\r\n" + 
					"                 order by POSTDATE DESC) a) b\r\n" + 
					" where b.rn between ? and ? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageVO.getBeginRecord());
			ps.setInt(2, pageVO.getEndRecord());
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getLong(1));
				dto.setAuthor(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getInt(5));
				dto.setPostdate(rs.getDate(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return list;
	}
	
	/* 3. 조회수(일반적으로 반환타입은 없음 - "조회수가 증가했습니다" 이런거 안나오잖아) */
	public void updateHit(long idx) {
		try {
			sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnector.getInstance().close(ps, null);
		}
	}
	
	/* 4. 게시글 반환 */
	public BoardDTO selectByIdx(long idx) {
		BoardDTO dto= null;
		try {
			sql = "SELECT AUTHOR, TITLE, CONTENT, HIT, POSTDATE FROM BOARD WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setIdx(idx);
				dto.setAuthor(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setHit(rs.getInt(4));
				dto.setPostdate(rs.getDate(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return dto;
	}
	
	/* 5. 게시글 삭제 */
	public int deleteBoard(long idx) {
		int result = 0;
		try {
			sql = "DELETE FROM BOARD WHERE IDX = ? ";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	
	/* 6. 게시글 수정 */
	public int updateBoard(BoardDTO dto) {
		int result = 0;
		try {
			sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setLong(3, dto.getIdx());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	
	/* 7. 전체 게시글의 개수 반환 */
	public int getTotalRecord() {
		int totalRecord = 0;
		try {
			sql = "SELECT COUNT(IDX) AS TOTAL_RECORD FROM BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalRecord = rs.getInt(1);	
					//totalRecord = rs.getInt("TOTAL_RECORD"); 이것과 같이 AS로 붙인 이름으로 가져올 수도 있음
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return totalRecord;
	}
	
	
}
