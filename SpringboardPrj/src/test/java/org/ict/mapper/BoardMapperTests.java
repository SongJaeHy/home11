package org.ict.mapper;

import java.sql.Connection;

import org.ict.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	// 이테스트코드 내에서는 Mapper테스트를 담당합니다.
	// 따라서 BoardMapper내부의 메서드를 실행할 예정이고
	// BoardMapper 타입의 변수가 필요하니
	// 선언해주시고 자동 주입으로 넣어주세요.
	@Autowired
	private BoardMapper mapper;
	
	// 테스트용 메서드의 이름은 testGetList입니다.
	// 테스트 코드가 실행될 수 있도록 만들어주세요.
	//@Test
	public void testGetList() {
		// mapper 내부의 getList 메서드를 호출하려면?
		log.info(mapper.getList());
	}
	
	// insert를 실행할 테스트코드를 하단에 작성해보겠습니다.
	//@Test
	public void testInsert() {
		// 글 입력을 위해서 BoardVO 타입을 매개로 사용함
		// 따라서 BoardVO를 만들어놓고
		// setter로 글제목, 글본문, 글쓴이 만 저장해둔 채로
		// mapper.insert(vo);를 호출해서 실행여부를 확인하면 됨.
		// 위 설명을 토대로 아래 vo에 6번글에 대한 제목 본문 글쓴이를 넣고
		// 호출해주신 다음 실제로 DB에 글이 들어갔는지 확인해주세요.
		BoardVO vo = new BoardVO();
		
		// 입력할 글에 대한 제목, 글쓴이, 본문을 vo에 넣어줍니다.
		vo.setTitle("새로넣는글");
		vo.setContent("새로넣는본문");
		vo.setWriter("새로넣는글쓴이");
		
		mapper.insert(vo);
	}
	
	@Test
	public void testSelect() {
		// 있는 글번호 입력시 데이터 출력
		mapper.select((long)6);
	}
	
}
