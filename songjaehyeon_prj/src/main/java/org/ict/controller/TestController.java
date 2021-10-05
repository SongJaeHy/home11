package org.ict.controller;

import java.util.ArrayList;
import java.util.List;

import org.ict.domain.TestVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi/*")
public class TestController {
	
	@RequestMapping("/success")
	public TestVO sendTestVO() {
		TestVO testVO = new TestVO();
		
		testVO.setName("송재현SUCCESS");
		return testVO;
	}
	
	@RequestMapping("/fail")
	public ResponseEntity<List<TestVO>> sendListNot(){
		List<TestVO> list = new ArrayList<>();
		for(int i=0; i <2; i++) {
			TestVO vo = new TestVO();
			vo.setName("송재현FAIL");
			list.add(vo);
		}
		
		return new ResponseEntity<List<TestVO>>(list, HttpStatus.BAD_REQUEST);
	}
}
