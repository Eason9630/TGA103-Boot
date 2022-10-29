package com.member.bootController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.member.service.impl.MemberServiceImpl;
import com.member.vo.MemberVO;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping(path = {"/api"})
public class login {
	@Autowired
	private MemberServiceImpl service;
	
	
	
	@RequestMapping(path = "/login")
	@PostMapping
	public MemberVO postLogin(@RequestBody MemberVO member) {
//		Integer id = member.getMember_id();
		String account = member.getAccount();
		String password = member.getPassword();
		
//		session.setAttribute("userId", id);
		MemberVO member1 = service.login(account, password);
		
		member1.setJwt(service.verifyUser(account, password));
		return member1;
	}
}
