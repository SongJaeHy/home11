package com.damoyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoyo.domain.PhotocategoryVO;
import com.damoyo.mapper.PhotocategoryMapper;

@Service
public class PCategoryServiceImpl implements CategoryService{
	
	@Autowired
	private PhotocategoryMapper mapper;
	
	@Override
	public void create(PhotocategoryVO vo) {
		mapper.insert(vo);
		
	}

	@Override
	public void update(Long m_num) {
		mapper.update(m_num);
		
	}

	@Override
	public void delete(Long p_num) {
		mapper.delete(p_num);
		
	}

}
