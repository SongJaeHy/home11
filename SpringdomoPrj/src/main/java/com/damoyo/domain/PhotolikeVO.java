package com.damoyo.domain;

import lombok.Data;

@Data
public class PhotolikeVO {
	private Long p_like_num; // 좋아요 번호
	private Long m_num; // 모임 번호
	private Long p_num; // 좋아요 원글 번호
	private String u_id; // 체크 유저 아이디
}
