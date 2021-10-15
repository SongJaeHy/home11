package com.damoyo.domain;

import lombok.Data;

@Data
public class PhotocommentsVO {
	private Long p_comment_num;
	private String p_comment_content;
	private Long m_num;
	private Long p_num;
	private String u_id;
	
	private PhotoVO photovo;
}
