package org.ict.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

// @Log4j는 로깅 기능을 쓸 수 있도록 도와줍니다,
// System.out.println(); 같은경우는 로깅만을 목적으로
// 나온 기능이 아니기 때문에 메모리를 잡아먹습니다.
// 따라서 로그를 찍을때 System.out.println();을 쓰는건 권장되지 않습니다
// 로깅만 할 수 있도록 Log4j를 사용합니다.
// 참고만 Log4j2는 spring boot 에서 쓰고, Log4j는 spring에서 씁니다.
@Log4j
public class OjdbcConnectionTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		@Test
		public void testConnection() {
			try(Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1",
					"mytest",
					"mytest"
					)){
				log.info(con);
				log.info("정상적으로 연결되었습니다.");
			}catch(Exception e) {
				fail(e.getMessage());
			}
		}
	}
}
