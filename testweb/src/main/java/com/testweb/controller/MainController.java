package com.testweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/") 							// 가장 상위의 경로 index
	public ModelAndView member() throws Exception { // View를 반환해 주어야 하기때문에 반환타입을 ModelAndView로 해준다.
		return new ModelAndView("index"); 			// member를 호출시 그 리스트를 가진 View를 반환해준다.
													// mapping, 보내는 정보의 이름, 보내는 것
	}

	// 회원 생성 페이지로 이동하기
	@RequestMapping(value = "/mem", method = RequestMethod.GET) // /mem을 GET으로 호출 할 시
	public ModelAndView createForm() throws Exception {
		return new ModelAndView("memberCreate"); 				// memberCreate View를 반환
	}

	// 회원 상세 페이지로 이동하기
	@RequestMapping(value = "/mem/{num}", method = RequestMethod.GET)// member/{num}을 GET으로 호출 할 시
	public ModelAndView view() throws Exception {
		return new ModelAndView("memberView"); 						 // memberView View를 반환
	}

	// 회원 상세 페이지로 이동하기
	@RequestMapping(value = "/mem/up", method = RequestMethod.GET) // member/up을 GET으로 호출 할 시
	public ModelAndView updateview() throws Exception {
		return new ModelAndView("memberUpdate"); 				   // memberUpdate View를 반환
	}
}