package com.damoyo.service;

import java.util.HashMap;

import com.damoyo.domain.PhotolikeVO;

public interface likeService {
	
	public void create(HashMap hashMap);
	
	public void update(Long p_like_num);
	
	public void delete(Long p_num);
	
	public int like_check(HashMap hashMap);
	
	public int like_check_cancel(HashMap hashMap);
}
