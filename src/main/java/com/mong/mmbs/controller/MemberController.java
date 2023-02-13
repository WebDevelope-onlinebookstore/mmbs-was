package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/searchEmail")
@Slf4j
public class MemberController {

	@Autowired MemberService memberService;
	
	/** 이메일이 DB에 존재하는지 확인 **/
    @GetMapping("/checkEmail/{userEmail}")
    public boolean checkEmail(@PathVariable("userEmail") String userEmail){

    	log.info("checkEmail 진입");
    	System.out.println(userEmail);
        return memberService.checkEmail(userEmail);
    }
    
    /** 비밀번호 찾기 - 임시 비밀번호 발급 **/
//    @PostMapping("/sendPwd")
//    public String sendPwdEmail(@RequestParam("memberEmail") String memberEmail) {
//
//        System.out.println("sendPwdEmail 진입");
//        System.out.println("이메일 : "+ memberEmail);
//
//        /** 임시 비밀번호 생성 **/
//        String tmpPassword = memberService.getTmpPassword();
//
//        /** 임시 비밀번호 저장 **/
//        memberService.updatePassword(tmpPassword, memberEmail);
//
//        /** 메일 생성 & 전송 **/
//        MailDto mail = mailService.createMail(tmpPassword, memberEmail);
//        mailService.sendMail(mail);
//
//        System.out.println("임시 비밀번호 전송 완료");
//
//        return "member/member-login";
//    }
    
    /** 비밀번호 찾기 - 임시 비밀번호 발급 **/

//    @PostMapping("/sendPwd")
//    public String sendPwdEmail(@RequestParam("memberEmail") String memberEmail) {
//
//    	System.out.println("sendPwdEmail 진입");
//    	System.out.println("이메일 : "+ memberEmail);
//
//        /** 임시 비밀번호 생성 **/
//        String tmpPassword = memberService.getTmpPassword();
//
//        /** 임시 비밀번호 저장 **/
//        memberService.updatePassword(tmpPassword, memberEmail);
//
//        /** 메일 생성 & 전송 **/
//        MailDto mail = mailService.createMail(tmpPassword, memberEmail);
//        mailService.sendMail(mail);
//
//        System.out.println("임시 비밀번호 전송 완료");
//
//        return "member/member-login";
//    }
}
