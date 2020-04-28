package com.exam.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dto.attach.AttachVO;
import com.exam.dto.board.BoardVO;
import com.exam.service.board.BoardService;
import com.exam.util.action.Action;
import com.exam.util.pagination.PageMaker;
import com.exam.util.request.CreatePageMaker;
import com.exam.util.summernote.MakeFileName;

public class BoardDetailAction implements Action{

	private BoardService boardService;
	
	public void setPdsService(BoardService pdsService) {
		this.boardService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/detail";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		String from = request.getParameter("from");
		
		try {
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			BoardVO board = null;
			if(from != null && from.equals("modify")) {
				board = boardService.read(bno);
			}else {
				board = boardService.getBoard(bno);	
			}
			
			List<AttachVO> renamedAttachList = MakeFileName.parseFileNameFromAttachs(board.getAttachList(), "\\$\\$");
			board.setAttachList(renamedAttachList);
			request.setAttribute("board", board);
			
			PageMaker pageMaker = CreatePageMaker.pageMaker(request);
			
			request.setAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		return url;
	}

}
