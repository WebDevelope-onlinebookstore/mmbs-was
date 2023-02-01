package com.mong.mmbs.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/mailTest", method = RequestMethod.GET)
	public void mailTest(String email){

	        Random random = new Random();
	        int checkNum = random.nextInt(888888) + 111111;

	        /* 이메일 보내기 */
	        String setFrom="메일 전송에 사용할 이메일";    /* ex) googleMail@gmail.com */
	        String toMail=email;    /* 메일을 받을 이메일 아이디   ex) naverMail@naver.com */
	        String title="회원가입 인증 이메일 입니다.";
	        String content=
	        "홈페이지를 방문해주셔서 감사합니다."+
	        "<br></br>"+
	        "인증 번호는 "+checkNum+" 입니다."+
	        "<br>"+
	        "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

	        try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
	        helper.setFrom(setFrom);
	        helper.setTo(email);
	        helper.setSubject(title);
	        helper.setText(content, true);
	        mailSender.send(message);

	        } catch (Exception e) {
	        e.printStackTrace();
	        }

	    }
}
