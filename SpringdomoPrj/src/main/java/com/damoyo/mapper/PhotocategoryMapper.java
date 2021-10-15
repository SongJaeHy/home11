package com.damoyo.mapper;

import com.damoyo.domain.PhotocategoryVO;

public interface PhotocategoryMapper {

	// 사진 모음 입력
	public void insert(PhotocategoryVO vo);
	
	// 수정
	public void update(Long m_num);
	
	// 삭제
	public void delete(Long p_num);
	
	
}
