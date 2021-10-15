package com.damoyo.like;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.damoyo.domain.PhotolikeVO;
import com.damoyo.mapper.PhotoLikeMapper;


@Component("com.damoyo.like.LiketoProc")
public class LiketoProc implements PhotoLikeMapper{
	
	@Autowired
	@Qualifier("dev.mvc.like.LiketoDAO")
	 private LiketoDAOInter liketoDAO = null;
	  
	  public LiketoProc(){
	    //System.out.println("--> LiketoProc() created");
	  }
	
	@Override
	public int countbyLike(HashMap hashMap) {
		 int count = liketoDAO.countbyLike(hashMap);
		    return count;
	}

	@Override
	public int create(HashMap hashMap) {
		 int count = liketoDAO.create(hashMap);
		    return count;
	}

	@Override
	public int like_check(HashMap hashMap) {
		 int count = liketoDAO.like_check(hashMap);
		    return count;
	}

	@Override
	public int like_check_cancel(HashMap hashMap) {
		  int count = liketoDAO.like_check_cancel(hashMap);
		    return count;
	}

	@Override
	public PhotolikeVO read(HashMap hashMap) {
		PhotolikeVO liketoVO = liketoDAO.read(hashMap);
	    return liketoVO;
	}

	@Override
	public int deletebyBoardno(Long p_num) {
		int count = liketoDAO.deletebyBoardno(p_num);
	    return count;
	}

	@Override
	public int deletebyMno(Long m_num) {
		 int count = liketoDAO.deletebyMno(m_num);
		    return count;
	}

	@Override
	public void update(Long p_like_num) {
		// TODO Auto-generated method stub
		
	}

}
