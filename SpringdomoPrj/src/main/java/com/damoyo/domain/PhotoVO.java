package com.damoyo.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class PhotoVO {
	private Long p_num;
	private String p_cate_name;
	private Date p_date;
	private int p_like;
	private String p_image1;
	private String p_image2;
	private String p_image3;
	private int p_view;
	private Long m_num;
	private String u_id;
}
