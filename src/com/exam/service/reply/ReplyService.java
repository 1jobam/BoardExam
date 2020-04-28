package com.exam.service.reply;

import java.sql.SQLException;
import java.util.Map;

import com.exam.dto.reply.ReplyVO;
import com.exam.util.pagination.SearchCriteria;

public interface ReplyService {
	
		//리스트보기
		Map<String,Object> getReplyList(int bno,SearchCriteria cri)
									throws SQLException;		
		//등록
		void registReply(ReplyVO reply)throws SQLException;
			
		//수정
		void modifyReply(ReplyVO reply)throws SQLException;
		
		//삭제
		void removeReply(int rno)throws SQLException;
}
