package com.basic.kim.Member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate as;
	
	public void insert(MemberVO bag) {
		System.out.println("멤버다오"+bag);
		as.insert("member.create",bag); 
	}
}
