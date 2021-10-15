package com.damoyo.mapper;

import java.util.List;

import com.damoyo.domain.PhotocommentsVO;

public interface PhotocommentMapper {

	public List<PhotocommentsVO> getList(Long p_comment_num);
	
	public void create(PhotocommentsVO vo);
	
	public void update(PhotocommentsVO vo);
	
	public void delete(Long p_num);
}
