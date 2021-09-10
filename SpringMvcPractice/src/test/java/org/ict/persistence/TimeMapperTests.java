package org.ict.persistence;

import org.ict.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	public TimeMapper timemapper;
	
	//@Test
	public void testGetTime() {
		log.info("햔재 시간 조회중...");
		log.info(timemapper.getTime());
	}
	
	// 기본적으로 복잡란 쿼리문을 작성을 하려면 xml파일과 인터페이스를 연동합니다.
	// 먼저, 인터페이스에는 아래와 같이 메서드르르 선언만  해 줍니다.
	// 그리고 같은 패키지 내부에 xml파일을 생성해놓고 거기에 실제로 getTime2가 호출될때
	// 실행할 실행문을 작성합니다.

	//@Test
	public void testGetTime2() {
		log.info("getTime2가 얻어온 시간");
		log.info(timemapper.getTime2());
	}
	
	@Test
	public void testGetTime3() {
		log.info("getTime3가 얻어온 시간");
		log.info(timemapper.getTime3());
	}
	
	
}
