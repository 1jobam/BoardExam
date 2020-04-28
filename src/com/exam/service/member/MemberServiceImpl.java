package com.exam.service.member;

import java.sql.SQLException;

import com.exam.dao.member.MemberDAO;
import com.exam.dto.member.MemberVO;
import com.exam.exception.NotFoundIdPwdException;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIdPwdException {
		MemberVO member = memberDAO.selectMemberById(id);
		if(member == null || !(member.getPwd().equals(pwd))){
			throw new NotFoundIdPwdException();
		}
	}
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}


}
