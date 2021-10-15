package com.damoyo.domain;

import lombok.Data;

// 검색기능 + 페이징 처리를 구현하기 위해 Criteria를 재사용하는
// SearchCriteria를 생성합니다.
@Data
public class PhotoSearchCriteria extends PhotoCriteria {

	private String searchType;
	private String keyword;
	
}
