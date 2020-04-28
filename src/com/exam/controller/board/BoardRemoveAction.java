package com.exam.controller.board;

import java.io.File;
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

public class BoardRemoveAction implements Action {

	private BoardService boardService;
	
	public void setPdsService(BoardService pdsService) {
		this.boardService = pdsService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/remove_success";

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			// 존재하는 파일삭제
			BoardVO board = boardService.read(bno);
			List<AttachVO> attach = board.getAttachList();
			if (attach != null) {

				for (AttachVO attachList : attach) {
					String attachRemove = attachList.getUploadPath() + File.separator + attachList.getFileName();
					System.out.println(attachRemove);
					File file = new File(attachRemove);
					if (file.exists()) {
						file.delete();
					}
				}
			}
			// db 삭제
			boardService.remove(bno);
			PageMaker pageMaker = CreatePageMaker.pageMaker(request);
			request.setAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			e.printStackTrace();
			url = "board/remove_fail";
		}

		return url;
	}

}
