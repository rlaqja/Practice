package com.basic.kim.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.kim.Service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(String id,String pw,String name) throws Exception {
		return memberService.insert(id, pw, name);
	}
}
