package com.basic.kim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.kim.Member.MemberDAO;
import com.basic.kim.Member.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO dao;
	
	@ResponseBody
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
