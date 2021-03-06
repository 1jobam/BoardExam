package com.exam.controller.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.board.BoardService;
import com.exam.util.action.Action;
import com.exam.util.pagination.SearchCriteria;

public class BoardListAction implements Action{
	
	private BoardService boardService;
	
	public void setPdsService(BoardService pdsService) {
		this.boardService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/list";
		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		SearchCriteria cri = new SearchCriteria();
		try {
			cri.setPage(Integer.parseInt(page));
			cri.setPerPageNum(Integer.parseInt(perPageNum));			
		}catch(NumberFormatException e) {
			System.out.println("페이지 번호를 1로 세팅합니다.");
		}
		if(searchType != null && keyword != null) {
			cri.setSearchType(searchType);
			cri.setKeyword(keyword);
		}
		
		try {
			Map<String,Object> dataMap = boardService.getList(cri);
			request.setAttribute("dataMap", dataMap);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		return url;
	}

}
