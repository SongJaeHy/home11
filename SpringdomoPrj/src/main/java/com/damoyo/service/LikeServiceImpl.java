package com.damoyo.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoyo.domain.PhotolikeVO;
import com.damoyo.mapper.PhotoLikeMapper;

@Service
public class LikeServiceImpl implements likeService{

	@Autowired
	private PhotoLikeMapper mapper;
	
	
	@Override
	public void create(HashMap hashmap) {
		mapper.create(hashmap);
		
	}

	@Override
	public void update(Long p_like_num) {
		mapper.update(p_like_num);
		
	}

	@Override
	public void delete(Long p_num) {
		mapper.deletebyBoardno(p_num);
		
	}

	@Override
	public int like_check(HashMap hashMap) {
		
		return mapper.like_check(hashMap);
	}

	@Override
	public int like_check_cancel(HashMap hashMap) {
		// TODO Auto-generated method stub
		return mapper.like_check_cancel(hashMap);
	}

}
