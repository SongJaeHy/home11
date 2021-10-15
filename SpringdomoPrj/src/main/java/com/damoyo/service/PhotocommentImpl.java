package com.damoyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoyo.domain.PhotocategoryVO;
import com.damoyo.domain.PhotocommentsVO;
import com.damoyo.mapper.PhotoMapper;
import com.damoyo.mapper.PhotocommentMapper;

@Service
public class PhotocommentImpl implements PCommentsService {

	@Autowired
	private PhotocommentMapper mapper;

	@Override
	public void addcomments(PhotocommentsVO vo) {
		mapper.create(vo);
		
	}

	@Override
	public List<PhotocommentsVO> listcomments(Long p_comment_num) {
		// TODO Auto-generated method stub
		return mapper.getList(p_comment_num);
	}

	@Override
	public void modifyReply(PhotocommentsVO vo) {
		mapper.update(vo);
		
	}

	@Override
	public void removeReply(Long p_num) {
		mapper.delete(p_num);
		
	}
	
	

}
