package com.damoyo.service;


import java.util.List;

import com.damoyo.domain.PhotoCriteria;
import com.damoyo.domain.PhotoSearchCriteria;

import com.damoyo.domain.PhotoVO;
import com.damoyo.domain.PhotocategoryVO;
import com.damoyo.domain.PhotolikeVO;


public interface PhotoService {
	
	// 사진 등록
	public void create(PhotoVO vo);
	
	// 사진 조회
	public PhotoVO get(Long p_num);
	
	// 사진 수정
	public void revise(PhotoVO vo);
	
	// 사진 삭제
	public void delete(Long p_num);
	
	// 사진 리스트
	public List<PhotocategoryVO> getlist(String keyword);
	
	// 사진 좋아요
	public void like(PhotolikeVO vo);
	
	// 사진 페이징
	public List<PhotoVO> getListPaging(PhotoSearchCriteria cri);
	
	// 사진 전체 개수
	public int gettotal(PhotoSearchCriteria cri);
	
}
