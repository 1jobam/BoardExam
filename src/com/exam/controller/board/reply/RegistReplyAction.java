package com.exam.controller.board.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.reply.ReplyService;
import com.exam.util.action.Action;
import com.exam.util.pagination.PageMaker;
import com.exam.util.pagination.SearchCriteria;
import com.exam.util.request.RegistReplyRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistReplyAction implements Action{
	
	private ReplyService replyService;
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		RegistReplyRequest replyReq = mapper.readValue(request.getReader(), RegistReplyRequest.class);
		
		response.setContentType("text/plain;charset=utf-8;");
		PrintWriter out = response.getWriter();
		
		try {
			replyService.registReply(replyReq.toReplyVO());
			
			SearchCriteria cri = new SearchCriteria();
			
			Map<String, Object> dataMap = replyService.getReplyList(replyReq.getBno(), cri);
			PageMaker pageMaker = (PageMaker)dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			out.print("SUCCESS,"+realEndPage);
			
		} catch (SQLException e) {
			e.printStackTrace();
			out.print("FAIL,1");
		}finally {
			if(out!=null)out.close();
		}
		
		return url;
	}

}
