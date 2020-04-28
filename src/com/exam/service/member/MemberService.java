package com.exam.service.member;

import java.sql.SQLException;

import com.exam.dto.member.MemberVO;
import com.exam.exception.NotFoundIdPwdException;

public interface MemberService {
	
	void login(String id, String pwd) throws SQLException, NotFoundIdPwdException;
	
	MemberVO getMember(String id) throws SQLException;
	
	void regist(MemberVO member)throws SQLException;

}
