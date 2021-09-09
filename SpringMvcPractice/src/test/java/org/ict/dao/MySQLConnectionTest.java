package org.ict.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class MySQLConnectionTest {
	private final String DRIVER="com.mysql.cj.jdbc.Driver";
	private final String URL ="jdbc:mysql://127.0.0.1:3306/mysql"
			+ "?useSSL=false&serverTimezone=UTC";
	private final String USER = "root";
	private final String PW = "1111";
	
	// 테스트 코드를 실행하면 @Test가 붙은 메서드만 실행합니다.
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			log.info(con);
			log.info("mysql에 연결되었습니다.");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	
}
