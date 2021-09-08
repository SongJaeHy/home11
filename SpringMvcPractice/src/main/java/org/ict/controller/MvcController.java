package org.ict.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 빈 컨테이너에 넣어주세요.(등록된 컨트롤러만 실제로 작동됨)
@Controller
public class MvcController {
	
	// 기본주소(localhost:8181)뒤에 /goA를 붙이면 goA()메서드 실행
	@RequestMapping(value="/goA")
	// return 타입이 String인 경우 결과 페이지를 지정할 수 있음
	public String goA() {
		System.out.println("goA 주소 접속 감지");
		// 결과 페이지는 views 폴더 아래의 A.jsp
		return "A";
	}
	
	// goB를 생성해주세요.
	// 결과 페이지는 B.jsp압나더
	@RequestMapping(value="/goB")
	
	public String goB() {
		System.out.println("goB 주소 감지");
		
		return "B";
	}

	// goC는 파라미터를 입력받을수있도록 해보겠습니다.
	@RequestMapping(value="/goC")
	// 주소 뒤 ?cNum=값 형태로 들어오는 값을 로직 내cNum으로 처리합니다.
	// 들어온 파라미터를 .jsp파일로 전달하기 위해서는
	// Model model를 파라미터에 추가로 선언해줍니다.
	public String goC(int cNum, Model model) {
		System.out.println("주소로 전달받은 값 : " + cNum);
		
		// 전달받은 cNum을 C.jsp에 출력하는 로직을 작성해주세요.
		model.addAttribute("cNum", cNum);
		return "C";
	}
	
	// goD는 requestParam을 이용해 변수명과 받는 이름이 일치하지 않게 해보겠습니다.
	@RequestMapping(value="/goD")
	// @RequestParam("대체이름")은 변수 왼쪽에 선언합니다.
	// 이렇게 되면 적힌 변수명 대신 대체이름으로 치환해 받아옵니다.
	public String goD(@RequestParam("d") int dNum, Model model) {
		
		System.out.println("d 변수명으로 받은게 dNum에 저장 : "+ dNum);
		
		return "D";
	}
}
