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
public abstract class CheckCode {
	@Autowired
	public MemberServiceImpl service;

	@RequestMapping(path = {"checkCode"})
	@PostMapping
	public MemberVO checkCode(@RequestBody MemberVO member , HttpSession session) {
	
	final String verification = ((MemberVO) session.getAttribute("forget")).getVerifyAccount();
		 
		member.setVerifyAccount(verification);
	        
		member = service.checkCode(member);
	
		return member;
	}
	
}
