package com.damoyo.service;

import com.damoyo.domain.PhotocategoryVO;

public interface CategoryService {
	
	public void create(PhotocategoryVO vo);
	
	public void update(Long m_num);
	
	public void delete(Long p_num);
}
