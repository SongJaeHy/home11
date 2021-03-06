package org.ict.service;

import java.util.List;

import org.ict.domain.ReplyVO;
import org.ict.mapper.BoardMapper;
import org.ict.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyServiceImpl implements ReplyService {

	// 서비스는 매퍼를 호출하기때문에 매퍼 생성
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public void addReply(ReplyVO vo) {
		mapper.create(vo);
		boardMapper.updateReplyCount(vo.getBno(), 1L);
		
	}

	@Override
	public List<ReplyVO> listReply(Long bno) {
		return mapper.getList(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) {
		mapper.update(vo);
	}
	
	@Transactional
	@Override
	public void removeReply(Long rno) {
		/* 내가 삭제하는 댓글이 몇 번 글에 달려있던건지 조회
		 * mapper.delete가 실행되는순간, bno를 포함한 모든 rno번 로우가 날아감.
		 * 먼저 bno를 얻어서 저장까지 한 다음, rno번 로우 삭제를 해야 마지막 로직 실행가능
		 */
		Long bno = mapper.getBno(rno);
		mapper.delete(rno);
		// 댓글 삭제 후 replycount에 1차감
		boardMapper.updateReplyCount(bno, -1L);
	}
}
