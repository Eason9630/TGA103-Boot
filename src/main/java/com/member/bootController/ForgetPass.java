package com.member.bootController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.service.impl.MemberServiceImpl;
import com.member.vo.MemberVO;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(path = {"/api"})
public class ForgetPass {

	@Autowired
	public MemberServiceImpl service;
	
	@RequestMapping(path = {"forgetPass"})
	@PostMapping
	public MemberVO forgetPass(@RequestBody MemberVO member,HttpSession session) {
		final String account = ((MemberVO) session.getAttribute("forget")).getAccount();
		
		member.setAccount(account);
        
		member = service.forgetPassChange(member);
		
		return member;
	}
}
