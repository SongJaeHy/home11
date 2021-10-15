package com.damoyo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damoyo.domain.PhotocommentsVO;
import com.damoyo.service.PCommentsService;


@RestController
@RequestMapping("/replie/")
public class PReplyController {
	
	@Autowired
	private PCommentsService service;
	
	@PostMapping(value="", consumes="application/json",
			produces= {MediaType.TEXT_PLAIN_VALUE})
	
	public ResponseEntity<String> regitster (
			// rest컨트롤러에서 받는 파라미터 앞에
			// @RequestBody 어노테이션이 붙어야
			// consumes와 연결됨
			@RequestBody PhotocommentsVO vo){
		ResponseEntity<String> entity=null;
		try {
			service.addcomments(vo);
			entity = new ResponseEntity<String>(
					"SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			// catch로 넘어왔다라는건 글쓰기 로직에 문제가 생긴 상황
			entity = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping(value="all/{p_comment_num}",
	produces= {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<PhotocommentsVO>> list(
			@PathVariable("p_comment_num") Long p_comment_num) {
		ResponseEntity<List<PhotocommentsVO>> entity = null;
		try{
			entity = new ResponseEntity<>(
					service.listcomments(p_comment_num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@DeleteMapping(value="/p_num",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(
			@PathVariable("p_num") Long p_num){
		ResponseEntity<String> entity = null;
		try {
			service.removeReply(p_num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
				value="/{p_num}",
				consumes= "application/json",
				produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(
			
			@RequestBody PhotocommentsVO vo,
			@PathVariable("p_num") Long p_num){
		ResponseEntity<String> entity = null;
		try {
			vo.setP_comment_num(p_num);
			service.modifyReply(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
}
