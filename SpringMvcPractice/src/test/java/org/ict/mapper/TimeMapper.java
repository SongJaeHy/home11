package org.ict.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT now()")
	public String getTime();
	
	
	public String getTime2();
	
	// getTime3를 만들어서 테스트코드에서 실행
	
	public String getTime3();
}
