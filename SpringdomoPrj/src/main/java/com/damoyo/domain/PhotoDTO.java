package com.damoyo.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PhotoDTO {
	
	//페이지네이션 버튼 설치
	private int btnNum;
	
	// 사진 시작하는 페이지
	private int startPage;
	
	// 사진 끝나는 페이지
	private int endPage;
	
	// 직전, 이후 10개 페이지 버튼
	private boolean prev, next;
	
	// 전체 사진 개수
	private int total;
	
	// 사진 전체 개수
	private PhotoCriteria cri;
	
	public PhotoDTO(PhotoCriteria cri, int total, int btnNum) {
		this.cri = cri;
		this.total = total;
		this.btnNum = btnNum;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/(double)this.btnNum)
				*this.btnNum);
		
		this.startPage = this.endPage - this.btnNum + 1;
		
		int realEnd = (int)(Math.ceil((total * 1.0)/ cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage == 1 ? false : true;
		this.next = this.endPage < realEnd;
		}
	}

