package com.damoyo.service;

import java.util.List;

import com.damoyo.mapper.PhotoMapper;
import com.damoyo.service.PhotoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damoyo.domain.PhotoVO;
import com.damoyo.domain.PhotocategoryVO;
import com.damoyo.domain.PhotolikeVO;
import com.damoyo.domain.PhotoCriteria;
import com.damoyo.domain.PhotoSearchCriteria;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j // 로깅을 위한 어노테이션 // x가 뜨면 pom.xml에서 추가수정
//자세한 사항은 pom.xml의 log4j 참조.
@Service // 의존성 등록을 위한 어노테이션
@AllArgsConstructor
public class PhotoServiceImpl implements PhotoService{

	@Autowired
	private PhotoMapper mapper;

	@Override
	public void create(PhotoVO vo) {
		log.info("등록 작업 실행");
		mapper.insertSelectKey(vo);
		
	}

	@Override
	public PhotoVO get(Long p_num) {
		PhotoVO photo = mapper.select(p_num);
		log.info(p_num + "번 사진 조회");
		return photo;
	}

	@Override
	public void revise(PhotoVO vo) {
		log.info("수정 작업 진행 - " + vo);
		mapper.update(vo);
		
	}

	@Override
	public void delete(Long p_num) {
		log.info(p_num + "번 사진 삭제 작업 진행");
		mapper.delete(p_num);
		
	}

	@Override
	public List<PhotocategoryVO> getlist(String keyword) {
		List<PhotocategoryVO> photoList = mapper.getList(keyword);
		log.info("전체 사진 목록 조회");
		return photoList;
	}

	@Override
	public void like(PhotolikeVO vo) {
		log.info("사진 좋아요");
		mapper.like(vo);
	}

	@Override
	public List<PhotoVO> getListPaging(PhotoSearchCriteria cri) {
		List<PhotoVO> photos = mapper.getListPaging(cri);
		return photos;
	}

	@Override
	public int gettotal(PhotoSearchCriteria cri) {
		// TODO Auto-generated method stub
		return mapper.gettotalPhoto(1L);
	}



	
	


	
}
