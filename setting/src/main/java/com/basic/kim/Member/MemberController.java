package com.basic.kim.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MemberController {
	
	@Autowired
	MemberDAO dao;
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(String id,String pw,String name ) {
		MemberVO bag = new MemberVO();
		bag.setId(id);
		bag.setPw(pw);
		bag.setName(name);
		System.out.println(bag);
		dao.insert(bag);
		return "1";
	}
}
