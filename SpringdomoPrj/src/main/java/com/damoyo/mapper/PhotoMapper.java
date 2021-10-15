package com.damoyo.mapper;

import java.util.List;

import com.damoyo.domain.PhotoSearchCriteria;

import com.damoyo.domain.PhotoVO;
import com.damoyo.domain.PhotocategoryVO;
import com.damoyo.domain.PhotolikeVO;

public interface PhotoMapper {
	
//	public PhotoVO get(Long p_num);
//	
//	public List<PhotoVO> getPhoto();
//	
//	// 사진 리스트
//	public List<PhotocategoryVO> getCate();
//	
//	// 사진 등록
//	public void insert(PhotoVO vo);
//	
//	// 사진 수정
//	public void update(PhotoVO vo);
//	
//	// 사진 삭제
//	public void delete(Long p_num);
//	
//	
	public List<PhotocategoryVO> getList(String keyword);
	
	// insert구문 실행용으로 메서드를 선언합니다.
	// VO내부에 적혀있는 정보를 이용해 insert를 합니다.
	// BoardVO를 매개로 insert 정보를 전달받음.
	public void insert(PhotoVO vo);
	
	// insertSelectKey를 매퍼, 서비스, 컨트롤러에 적용시켜주세요.
	public void insertSelectKey(PhotoVO vo);
	
	// 사진 번호(Long bno)를 파라미터로 받아
	// 해당 글 번호에 해당하는 글을 리턴해 보여주는 메서드를 작성해주세요.
	// 메서드 이름은 select 입니다.
	// xml파일에 쿼리문도 작성해보겠습니다.
	public PhotoVO select(Long p_num);
	
	// 사진 번호(Long bno)를 파라미터로 바당
	// 해당 글 번호에 해당하는 글을 삭제해주는 메서드를 작성해주세요.
	// 메서드 이름은 delete 입니다.
	// xml파일에 쿼리문도 작성해주시고
	// 테스트코드까지 만들어 실제로 삭제되는지 sqldeveloper로 봐주세요.
	public void delete(Long p_num);
	
	// 사진 수정 로직을 작성해보겠습니다.
	// PhotoVO를 받아서 수정해줍니다.
	// 바꿀 내역은, p_cate_name, p_image1, p_view는 vo에서 받아서
	// p_date는 sysdate로
	// where 구문은 p_num로 구분해서 처리합니다.
	// 수정로직을 작성해주시고, 테스트까지 해 주세요.
	public void update(PhotoVO vo);
	
	public void like(PhotolikeVO vo);
	
	// 사진 페이징
	public List<PhotoVO> getListPaging(PhotoSearchCriteria cri);
	
	// 사진 전체갯수
	public int gettotalPhoto(Long p_num);
}
