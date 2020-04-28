package com.exam.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exam.dao.attach.AttachDAO;
import com.exam.dao.board.BoardDAO;
import com.exam.dao.reply.ReplyDAO;
import com.exam.dto.attach.AttachVO;
import com.exam.dto.board.BoardVO;
import com.exam.util.pagination.PageMaker;
import com.exam.util.pagination.SearchCriteria;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	private ReplyDAO replyDAO;
	
	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}
	
	private AttachDAO attachDAO;
	
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO=attachDAO;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		
		List<BoardVO> boardList = boardDAO.selectBoardCriteria(cri);
		List<AttachVO> attachList = null;
		for(BoardVO board : boardList) {
			int bno = board.getBno();
			attachList = attachDAO.selectAttachesByBno(bno);
		}
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardDAO.selectBoardCriteriaTotalCount(cri));
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("boardList", boardList);
		dataMap.put("pageMaker", pageMaker);
		dataMap.put("attachList", attachList);
		
		return dataMap;
	}
	@Override
	public BoardVO getBoard(int bno) throws SQLException {
		boardDAO.increaseViewCnt(bno);
		BoardVO board = boardDAO.selectBoardByBno(bno);
		List<AttachVO> attachList=attachDAO.selectAttachesByBno(bno);
		board.setAttachList(attachList);
		return board;
	}
	@Override
	public void regist(BoardVO board) throws SQLException {
		int bno = boardDAO.selectBoardSeqNext();
		board.setBno(bno);
		boardDAO.insertBoard(board);
		for(AttachVO attach:board.getAttachList()) {
			attach.setBno(bno);
			attach.setAttacher(board.getWriter());
			attachDAO.insertAttach(attach);
		}
	}
	@Override
	public void modify(BoardVO board) throws SQLException {
		boardDAO.updateBoard(board);		
		for(AttachVO attach:board.getAttachList()) {
			attach.setBno(board.getBno());
			attach.setAttacher(board.getWriter());
			attachDAO.insertAttach(attach);
		}
	}
	@Override
	public void remove(int bno) throws SQLException {
		boardDAO.deleteBoard(bno);
	}
	@Override
	public BoardVO read(int bno) throws SQLException {
		BoardVO board = boardDAO.selectBoardByBno(bno);
		List<AttachVO> attachList=attachDAO.selectAttachesByBno(bno);
		board.setAttachList(attachList);
		boardDAO.increaseViewCnt(bno);
		
		
		return board;
	}

}
