package com.damoyo.like;

import java.util.HashMap;

import com.damoyo.domain.PhotolikeVO;

public interface LiketoDAOInter {
	public int countbyLike(HashMap hashMap);
	  
	  /* 좋아요 번호 등록 */
	  public int create(HashMap hashMap);
	  
	  /**
	   * 좋아요 체크 여부 (0 -> 1)
	   * @param hashMap
	   * @return
	   */
	  public int like_check(HashMap hashMap);
	  
	  /**
	   * 좋아요 체크 여부 (1 -> 0)
	   * @param hashMap
	   * @return
	   */
	  public int like_check_cancel(HashMap hashMap);
	  
	  /* 조회 */
	  public PhotolikeVO read(HashMap hashMap);
	  
	  /* 게시판의 좋아요 삭제 */
	  public int deletebyBoardno(Long p_num);
	  
	  /* 회원의 좋아요 삭제 */
	  public int deletebyMno(Long m_num);
}
