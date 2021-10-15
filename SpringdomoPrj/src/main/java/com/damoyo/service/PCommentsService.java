package com.damoyo.service;

import java.util.List;



import com.damoyo.domain.PhotocommentsVO;

public interface PCommentsService {

	public void addcomments(PhotocommentsVO vo);
	
	public List<PhotocommentsVO> listcomments(Long p_comment_num);
	
	public void modifyReply(PhotocommentsVO vo);
	
	public void removeReply(Long p_num);
}
