package com.exam.controller.commons;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dto.member.MemberVO;
import com.exam.exception.NotFoundIdPwdException;
import com.exam.service.member.MemberService;
import com.exam.util.action.Action;

public class LoginAction implements Action{
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "redirect:/board/list.do";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		try {
			memberService.login(id, pwd);
			
			MemberVO loginUser = memberService.getMember(id);
			
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60*6);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
		} catch (NotFoundIdPwdException e) {
			url = "redirect:/commons/loginForm.do";
			System.out.println("아이디 또는 패스워드 불일치");
			request.setAttribute("msg", e.getMessage());
		}
		
		return url;
	}

}
