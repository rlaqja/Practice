package com.basic.kim.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.kim.Service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	MemberDAO dao;
	
	@Autowired
	MemberService memberService;
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request) throws Exception {
		return memberService.insert(request);
	}
	
	//이메일 인증
    @RequestMapping(value = "/mailCheck", produces = "application/text; charset=utf8")
  	@ResponseBody
  	public String mailCheck(@ModelAttribute("email") String email) {
  	    return dao.joinEmail(email);
  	}
    
    @RequestMapping(value = "/idCheck", method = { RequestMethod.GET }, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest req, HttpServletResponse resp, HttpSession session, String id) {
		dao.idCheck(id);
		if (id.length() >= 6) {
			if (dao.idCheck(id) != null) {
				return "기존에 있는 아이디입니다";
			} else {
				return "가입 가능한 아이디입니다.";	
			}
		}else {
			return "6자 이상으로 입력해야합니다.";
		}
	}
}
