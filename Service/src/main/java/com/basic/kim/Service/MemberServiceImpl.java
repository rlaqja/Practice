package com.basic.kim.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.kim.Bcrypt.Bcrypt;
import com.basic.kim.Member.MemberDAO;
import com.basic.kim.Member.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO dao;
	
	@ResponseBody
	public String insert(HttpServletRequest request ) {
		MemberVO bag = new MemberVO();
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String birth = request.getParameter("birth");
        String gender = request.getParameter("gender");
        
        Bcrypt bcry = new Bcrypt();
        String bcryPw= bcry.encrypt(pw);
        bag.setPw(bcryPw);
        bag.setId(id);
        bag.setName(name);
        bag.setTel(tel);
        bag.setNickname(nickname);
        bag.setEmail(email);
        bag.setGender(gender);
        try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(birth);
			bag.setBirth(date);
        } catch (Exception e) {
			e.printStackTrace();
		}
        if (id.length() >= 6) {
        	dao.insert(bag);
		} else {
		   return "0";
		}
		return "1";
	}
	
	//이메일 인증
    @RequestMapping(value = "member/mailCheck", produces = "application/text; charset=utf8")
  	@ResponseBody
  	public String mailCheck(@ModelAttribute("email") String email) {
  	    return dao.joinEmail(email);
  	}
    
}
