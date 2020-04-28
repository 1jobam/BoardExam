package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dto.board.BoardVO;
import com.exam.service.board.BoardService;
import com.exam.util.action.Action;

public class BoardModifyFormAction implements Action{

	private BoardService boardService;// = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/modifyBoard";
		
		try {
			
			int bno = Integer.parseInt(request.getParameter("bno"));
			
			BoardVO board = boardService.getBoardForModify(bno);
			
			request.setAttribute("board", board);
			
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error_500error";
		}
		
		return url;
	}

}
