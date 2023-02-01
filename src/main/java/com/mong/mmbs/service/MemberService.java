package com.mong.mmbs.service;

import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	
	//이메일발송
	public void sendEmail(MemberVO vo, String div) throws Exception;

	//비밀번호찾기
	public void findPw(HttpServletResponse resp, MemberVO vo) throws Exception;

}
