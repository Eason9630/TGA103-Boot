package com.member.bootController;

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
@RequestMapping("/api")
public class Register {
	@Autowired
	private MemberServiceImpl service;
	
	@RequestMapping(path = "/register")
	@PostMapping()
	public MemberVO method(@RequestBody MemberVO member) {
		MemberVO result = service.register(member);
//		System.out.println(result);

		return result;
		
	}
	
	
}
