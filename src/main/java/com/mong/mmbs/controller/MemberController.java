package com.mong.mmbs.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MemberController {

	/* 비밀번호 찾기 */
	@RequestMapping(value = "/findpw", method = RequestMethod.GET)
	public void findPwGET() throws Exception{
	}

	@RequestMapping(value = "/findpw", method = RequestMethod.POST)
	public void findPwPOST(@ModelAttribute MemberVO member, HttpServletResponse response)
			throws Exception{service.findPw(response, member);
	}
}
