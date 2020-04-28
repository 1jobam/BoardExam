package com.exam.dao.member;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.dto.member.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSessionFactory sessionFactory;
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session = sessionFactory.openSession();
		
		MemberVO member = null;
		try {
			member = session.selectOne("Member-Mapper.selectMemberById",id);
		}finally {
			if(session != null)session.close();
		}
		return member;
	}

}
