package ict.sjh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ict.sjh.domain.PhotoVO;
import ict.sjh.service.PhotoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/photo/*")

@AllArgsConstructor
public class PhotoController {
	
	@Autowired
	private PhotoService service;
	
	// 사진 등록
	@PostMapping("/enrollment")
	public String enrollment(PhotoVO vo,RedirectAttributes rttr) {
		service.enrollment(vo);
		log.info("insert" + vo);
		
		
		
		return null;
		
	}
	@RequestMapping(value="requestupload1")
	public String requestupload1(MultipartHttpServletRequest mtfRequest) {
		return "redirect:/";
		
	}



}
