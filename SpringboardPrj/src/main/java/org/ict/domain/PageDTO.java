package org.ict.domain;

import lombok.Getter;
import lombok.ToString;

// DTO는 Data Transfer Object로 데이터 전달 객체라고 합니다.
// DTO나 VO나 엄격하게 구분되는것은 아니고 둘 다 특정 데이터를
// 한 변수에 묶어서 보내기 위해 사용합니다.
// 차이점이 있다면 VO는 DB에서 바로 꺼낸 데이터를 매칭시키고
// DTO는 DB에 있는 정보를 토대로 가공한데이터를 전달할깨
// 사용한다는 차이가 있습니다.
@Getter
@ToString
public class PageDTO {
	
	// 페이지네이션 버튼을 몇 개 설치
	private int btnNum;
	// 페이지 세트 중 시작하는 페이지
	// 16페이지 조회중이라면 11이 시작페이지
	private int startPage;
	// 페이지 세트 중 끝나는 페이지
	// 16페이지 조회중이라면 20이 끝페이지
	private int endPage;
	// 직전, 이후 10개 페이지 버튼 유무여부
	private boolean prev, next;
	
	// 전체 데이터 개수
	private int total;
	// 페이지, 글 정보
	private Criteria cri;
	
	// btnNum은 우선 10개로 간주
	// 위의 변수 정보들을 자동으로 계산하게 하기 위한 생성자
	public PageDTO(Criteria cri, int total, int btnNum) {
		this.cri = cri;
		this.total = total;
		this.btnNum = btnNum;
		
		// 위에서 저장된 멤버변수를 이용해 나머지 정보 구하기
		
		// 끝페이지를 먼저 구하고
		/* 끝페이지 공식
		 * 현재 보고있는 페이지를 (실수인)btnNum으로 나눴다가
		 * 다시 곱한 결과물에 올림을 하고 btnNum을 다시 곱해
		 * 자릿수를 원상복구시킵니다.
		 */
	this.endPage = (int)(Math.ceil(cri.getPageNum() / (double)this.btnNum)
				* this.btnNum);
	// 다음 시작페이지는 끝페이지-까는버튼수 +1을 해서 구함
	// endPage를 구했으면, 그걸 토대로 startPage를 구합니다.
	this.startPage = this.endPage - this.btnNum + 1;
	
	int realEnd = (int)(Math.ceil((total * 1.0)/ cri.getAmount()));
	
	if(realEnd < this.endPage) {
		this.endPage = realEnd;
	}
	this.prev = this.startPage == 1 ? false : true;
	this.next = this.endPage < realEnd;
	}
	
	
	
}
