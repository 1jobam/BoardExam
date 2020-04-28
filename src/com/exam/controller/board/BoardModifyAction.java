package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dto.board.BoardVO;
import com.exam.service.board.BoardService;
import com.exam.util.action.Action;
import com.exam.util.request.BoardModifyRequest;

public class BoardModifyAction implements Action{
	
	private BoardService boardService;// = BoardServiceImpl.getInstance();
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/modify_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardModifyRequest boardModifyRequest = new BoardModifyRequest(bno, title, content);
		
		BoardVO board = boardModifyRequest.toBoardModify();
		
		try {
			boardService.modify(board);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "board/modify_fail";
		}
		
		return url;
	}

}
