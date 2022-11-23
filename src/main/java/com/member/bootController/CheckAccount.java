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
public class CheckAccount {
	@Autowired
	private MemberServiceImpl service;
	
	@RequestMapping(path = {"/checkAccount"})
	@PostMapping
	public MemberVO checkAccount(@RequestBody MemberVO member,HttpSession session) {
		
		member = service.forgetPass(member);
		System.out.println(member);
		if (member.isSuccessful()) {
			session.setAttribute("forget", member);
		}
		System.out.println(member.isSuccessful());
		
		return member;
	}
}
