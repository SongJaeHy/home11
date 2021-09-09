package org.ict.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
// 의존성 주입으로 생성한 Connection Pool 관련 변수를 가져오기 위해서

@RunWith(SpringJUnit4ClassRunner.class)
// Beans Graph 내부에 설정되어있는 dataSource를 쓰기 위해 위치 설정
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MySQLConnectionPoolTest {
	
	// 자동 설정
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnetion() {
		try(Connection con = dataSource.getConnection()){
			log.info(con);
			log.info("hikariCP connected");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
