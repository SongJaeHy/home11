package com.damoyo.like;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.damoyo.domain.PhotolikeVO;

@Repository("com.damoyo.like.LiketoDAO")
public class LikeDAO implements LiketoDAOInter{

	@Autowired
	  private SqlSessionTemplate mybatis;
	  
	  public LikeDAO(){
	    //System.out.println("--> LiketoDAO() created");
	  }
	
	@Override
	public int countbyLike(HashMap hashMap) {
		int count = mybatis.selectOne("like.countbyLike", hashMap);
	    return count;
	}

	@Override
	public int create(HashMap hashMap) {
		int count = mybatis.insert("like.create", hashMap);
	    return count;
	}

	@Override
	public int like_check(HashMap hashMap) {
		 int count = mybatis.update("like.like_check", hashMap);
		    return count;
	}

	@Override
	public int like_check_cancel(HashMap hashMap) {
		 int count = mybatis.update("like.like_check_cancel", hashMap);
		    return count;
	}

	@Override
	public PhotolikeVO read(HashMap hashMap) {
		 PhotolikeVO liketoVO = mybatis.selectOne("like.read", hashMap);
		    return liketoVO;
	}

	@Override
	public int deletebyBoardno(Long p_num) {
		 int count = mybatis.delete("like.deletebyBoardno", p_num);
		    return count;
	}

	@Override
	public int deletebyMno(Long m_num) {
		 int count = mybatis.delete("liketo.deletebyMno", m_num);
		    return count;
	}

}
