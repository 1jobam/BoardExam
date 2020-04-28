package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.board.BoardService;
import com.exam.util.action.Action;

public class BoardRemoveAction implements Action{
	
	private BoardService boardService;// = BoardServiceImpl.getInstance();
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/remove_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		try {
			boardService.remove(bno);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "board/remove_fail";
		}
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out=response.getWriter();
//		out.println("<script>");
//		out.println("alert('삭제되었습니다');");
//		out.println("window.opener.location.reload(true);window.close();");
//		out.println("</script>");
		
		return url;
		
	}

}
