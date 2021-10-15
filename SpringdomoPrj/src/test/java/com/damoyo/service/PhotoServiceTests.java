package com.damoyo.service;


import com.damoyo.domain.PhotoVO;
import com.damoyo.domain.PhotocategoryVO;
import com.damoyo.domain.UserVO;
import com.damoyo.service.PhotoServiceTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PhotoServiceTests {
	@Autowired
	private PhotoService service;
	
	//@Test
	public void testExits() {
		log.info(service);
		
		assertNotNull(service);
	}
	
	//@Test
		public void testGetList() {
			service.getlist("");
		}
		
	//@Test
	public void testGet() {
			service.get(7L);
		}
	//@Test
		public void testModify() {
			PhotoVO vo = new PhotoVO();
			UserVO vo1 = new UserVO();
			PhotocategoryVO vo2 = new PhotocategoryVO();
			
			vo.setP_num(2L);
			vo2.setP_cate_name("수정");
			vo.setP_image1("수정이다");
			vo1.setU_id("wa");
			
			service.revise(vo);
		}
	@Test
	public void testRemove() {
		service.delete(1L);
	}
}
