package com.damoyo.controller;

import com.damoyo.controller.PhotoControllerTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}
)// controller를 호출해야해서 둘 다 포함시켜야 함
@Log4j
@WebAppConfiguration 
public class PhotoControllerTest {
	
	@Autowired
	private WebApplicationContext ctx;
	
	// 브라우저 없이 모의로 접속하는 기능을 가진 객체
	private MockMvc mockMvc;
	
	// @Test 이전에 실행할 내용을 기술하는 어노테이션
	// 주의! org.junit.before로 입력해주세요.
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	// 사진 정보
	public void photoInfo() throws Exception{
		log.info(
				// .get(접속주소)/.post(접속주소) 를 제외한 나머지는
				// 다 고정된 양식을 가진 코드이므로 복잡해보이지만
				// 실제로는 복사붙여넣기로 쓰셔도 무방합니다.
				// .get(접속주소)를 입력하면 get방식으로 해당 주소에
				// 접속합니다.
				// /board/list 에 접속하면 글 목록 가져오기 페이지이기 때문에
				// 글 전체 목록을 가져오는지 여부를 테스트해야 합니다.
				mockMvc.perform(
					MockMvcRequestBuilders.get("/photo/list"))
					.andReturn()
					.getModelAndView()
					.getModelMap()
					);
		
	}
	@Test
		public void testRegister() throws Exception {
			
			// 아래 코드는 post방식으로 파라미터 3개를 주소에 전달해주는 코드입니다.
			// 결과 메세지는 문자열 resultPage에 저장해두고
			String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/photo/create")
				.param("p_view", "1")
				.param("p_cate_name", "테스트")
				.param("u_id", "테스트다")
				).andReturn().getModelAndView().getViewName();
			 
			//변수에 저장된 값을 다시 로깅을 해서 출력합니다.
			log.info(resultPage);
		}
}
