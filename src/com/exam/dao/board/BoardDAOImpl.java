package com.exam.dao.board;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.dto.board.BoardVO;
import com.exam.util.pagination.SearchCriteria;

public class BoardDAOImpl implements BoardDAO {
		
	private SqlSessionFactory sessionFactory;
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds=new RowBounds(offset,limit);
		
		List<BoardVO> BoardList=session.selectList("Board-Mapper.selectSearchBoardList",cri,rowBounds);	
			
		session.close();
		return BoardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		
		int count= session.selectOne("Board-Mapper.selectSearchBoardListCount",cri);
		
		session.close();
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		
		BoardVO pds=session.selectOne("Board-Mapper.selectBoardByBno",bno);
		
		session.close();
		return pds;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		try {
		session.update("Board-Mapper.insertBoard",board);
		}finally {
			if(session!=null)session.close();			
		}

	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		
		session.update("Board-Mapper.updateBoard",board);
		
		session.close();

	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		
		session.update("Board-Mapper.deleteBoard",bno);
		
		session.close();

	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		
		session.update("Board-Mapper.increaseViewCnt",bno);
		
		session.close();

	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		SqlSession session = sessionFactory.openSession(true);
		
		int bno=session.selectOne("Board-Mapper.selectBoardSeqNext");
		
		session.close();
		return bno;
	}

}
