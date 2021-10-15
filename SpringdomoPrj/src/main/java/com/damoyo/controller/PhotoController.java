package com.damoyo.controller;

import com.damoyo.domain.PhotoCriteria;
import com.damoyo.domain.MeetVO;
import com.damoyo.domain.PhotoDTO;
import com.damoyo.domain.PhotoVO;
import com.damoyo.domain.PhotocategoryVO;
import com.damoyo.domain.PhotolikeVO;
import com.damoyo.domain.UserVO;
import com.damoyo.mapper.PhotoMapper;
import com.damoyo.service.PhotoService;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.damoyo.domain.PhotoSearchCriteria;

import com.damoyo.domain.PhotoDTO;

import com.damoyo.domain.PhotoSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/photo/*") // 클래스 위에 작성시
//이 클래스를 사용하는 모든 메서드의 연결주소 앞에 /board/ 추가
@AllArgsConstructor
public class PhotoController {
	
	@Autowired
	private PhotoService service;
	
	
	@GetMapping("/list")
	public void list(Model model, HttpSession session, PhotoSearchCriteria cri) {
		log.info("사진 리스트");
		List<PhotoVO> photos = service.getListPaging(cri);
		
		//UserVO userInfo = (UserVO) session.getAttribute("userInfo");
		//MeetVO meetInfo = (MeetVO) session.getAttribute("meetInfo");
		int total = service.gettotal(cri);
		//List<PhotocategoryVO> category = service.getlist();
		PhotoDTO btnMaker = new PhotoDTO(cri, total, 10);
		
		model.addAttribute("btnMaker", btnMaker);
		model.addAttribute("list", photos);
		//model.addAttribute("category", category);
		//model.addAttribute("list", "list");
		
	}
	
	@PostMapping("/create")
	public String create(PhotoVO vo, RedirectAttributes rttr) {
		service.create(vo);
		log.info("사진 등록");
		
		rttr.addFlashAttribute("p_num", vo.getP_num());
		rttr.addFlashAttribute("succees", "create");
		
		return "redirect:/photo/list";
	}
	@GetMapping("/create")
	public String register() {
		return "/photo/create";
	}
	
	@PostMapping("/update")
	public String update(PhotoVO vo, PhotoSearchCriteria cri, RedirectAttributes rttr) {
			log.info("수정로직입니다." + vo);
			service.revise(vo);
			
			// rttr.addAttribute("파라미터명", "전달자료")
			// 는 호출되면 redirect 주소 뒤에 파라미터를 붙여줍니다.
			// rttr.addFlashAttribute()는 넘어간 페이지에서 파라미터를
			// 쓸 수 있도록 전달하는 것으로 둘의 역할이 다르니 주의해주세요.
			rttr.addAttribute("p_num", vo.getP_num());
			

			// 상세 페이지는 bno가 파라미터로 주어져야 하기 때문에
			// 아래와 같이 리턴구문을 작성해야 합니다.
			return "redirect:/photo/get";
	}
	
	@GetMapping("/update")
	public String update(Long p_num, Model model) {
		PhotoVO vo = service.get(p_num);
		
		model.addAttribute("vo", vo);
		return "/photo/update";
	}
	
	@PostMapping("/delete")
	public String delete(Long p_num, RedirectAttributes rttr, HttpSession session) {
		PhotoVO photo = (PhotoVO) session.getAttribute("photo");
		service.delete(p_num);
		rttr.addFlashAttribute("photo", photo);
		return "redirect:/main/";
		
	}
	@GetMapping("/like")
	public String like(PhotolikeVO vo) {
		log.info("좋아요");
		service.like(vo);
		return "/like";
		
	}
	@GetMapping("/get")
	public String get(Long p_num, Model model) {
		// 모든 로직 실행 전 bno가 null로 들어오는 경우
		if(p_num == null) {
			return "redirect:/photo/list";
		}
		
		// 현재 윗 라인 기준으로는 글 번호만 전달받은 상황임
		// 번호를 이용해 전체 글 정보를 받아오는게 우선 진행할 사항임.
		// bno번 글의 전체 정보를 vo에 저장함.
		PhotoVO vo = service.get(p_num);
		log.info("받아온 객체 : " + vo);
		// .jsp파일로 vo를 보내기 위해
		model.addAttribute("vo", vo);
		// board폴더의 get.jsp로 연결
		return "/photo/get";
	}
}
