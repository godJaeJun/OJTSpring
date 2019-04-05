package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.member.domain.MemberVO;
import com.member.mapper.MemberMapper;

// RestController는 @Controller와 @ResponseBody가 합쳐진 어노테이션이다. 
// view가 필요없는 API만 지원하는 서비스에서 사용되는데 현재는 view가 필요하기 때문에 @Controller를 사용해준다.
@Controller
@RequestMapping("/member") // 가장 상위의 경로를 member로 잡아준다.
public class MemberController {

	// 애플리케이션 컨텍스트상에서 다른 빈을 찾아 빈 간의 의존성을 자동으로 만족시키도록 하는 수단.
	@Autowired
	private MemberMapper memberMapper;

	// 회원 목록 /member를 GET으로 호출시
	@RequestMapping(method = RequestMethod.GET) // method를 활용하여 REST API를 제작 GET으로 호출시
	public ModelAndView member() throws Exception { // View를 반환해 주어야 하기때문에 반환타입을 ModelAndView로 해준다.
		List<MemberVO> list = memberMapper.memberList();// list를 Mapper의 memberList를 통해 받아온다.

		return new ModelAndView("memberList", "list", list);	// member를 호출시 그 리스트를 가진 View를 반환해준다.
								// mapping, 보내는 정보의 이름, 보내는 것
	}

	// 회원 생성 페이지로 이동하기
	@RequestMapping(value = "/mem", method = RequestMethod.GET)	//member/mem을 GET으로 호출 할 시
	public ModelAndView createForm() throws Exception {			
		return new ModelAndView("memberCreate");				//memberCreate View를 반환
	}

	// 회원 생성하기( POST ) @ModelAttribute를 사용하면 파라미터를 1:1로 전담 프로퍼티에 담아낸다. 
	// 사용하지 않을 경우 파라미터 값을 하나씩 담아줘야 한다.
	@RequestMapping(value = "/mem", method = RequestMethod.POST) //member/mem을 POST로 호출 할 시
	public String create(@ModelAttribute("MemberVO") MemberVO member) throws Exception {
		memberMapper.memberInsert(member);			//memberInsert안에 member값을 넣는다.
		return "redirect://localhost:8080/member";	//redirect 기본 페이지로 보내준다.
	}

	// 회원 상세
	@RequestMapping(value = "/{num}", method = RequestMethod.GET)	//member/num 의 값일 경우 상세 페이지 호출
	public ModelAndView view(@PathVariable("num") int num) throws Exception {

		MemberVO member = memberMapper.memberView(num);			//member객체를 받아온다. memberView를 통해서

		return new ModelAndView("memberView", "member", member);
		//memberView페이지를 반환한다. <- 이페이지에 member라는 것에 member를 담아준다.
	}

	// 회원 수정 페이지
	@RequestMapping(value = "/mem/{num}", method = RequestMethod.GET)	// member/mem/num 이 GET으로호출 될 시 
	public ModelAndView updateForm(@PathVariable("num") int num) throws Exception {
		MemberVO member = memberMapper.memberView(num);	//memberView를 받아와

		return new ModelAndView("memberUpdate", "member", member);	//memberUpdate View를 반환
	}

	// 회원 수정(PATCH) member/mem/num 을 PATCH로 호출 시에 불러옴 @PathVariable은 말그대로 URL경로에 변수를 넣어주는 것이다.
	@RequestMapping(value = "/mem/{num}", method = RequestMethod.PATCH)
	public String update(@ModelAttribute("MemberVO") MemberVO member, @PathVariable("num") int num) throws Exception {

		// memberMapper을 memberUpdate를 호출 
		memberMapper.memberUpdate(member);
		
		// 작업이 끝난 후 회원상세 페이지로 이동한다.
		return "redirect://localhost:8080/member/" + num;
	}

	// 회원 삭제(DELETE) DELETE로 호출 할 시
	@RequestMapping(value = "/mem/{num}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("num") int num) throws Exception {

		memberMapper.memberDelete(num);

		// 삭제 후 member로 돌아감
		return "redirect://localhost:8080/member";
	}
}
