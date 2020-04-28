package com.exam.dao.member;

import java.sql.SQLException;

import com.exam.dto.member.MemberVO;

public interface MemberDAO {

	MemberVO selectMemberById(String id) throws SQLException;
	
}
