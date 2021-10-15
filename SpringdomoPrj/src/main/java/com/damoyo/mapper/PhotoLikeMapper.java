package com.damoyo.mapper;

import java.util.HashMap;

import com.damoyo.domain.PhotolikeVO;

public interface PhotoLikeMapper {
	
	public int countbyLike(HashMap hashMap);
	
	// 좋아요 번호 등록
	public int create(HashMap hashMap);
	
	public int like_check(HashMap hashMap);
	  
	public int like_check_cancel(HashMap hashMap);
	  
	  /* 조회 */
	public PhotolikeVO read(HashMap hashMap);
	
	public int deletebyBoardno(Long p_num);
	  
	  /* 회원의 좋아요 삭제 */
	public int deletebyMno(Long m_num);
	
	public void update(Long p_like_num);
}
