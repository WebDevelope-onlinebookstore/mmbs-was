package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mong.mmbs.dto.FindIdDto;
import com.mong.mmbs.dto.FindPasswordDto;
import com.mong.mmbs.dto.MailDto;
import com.mong.mmbs.dto.ResetPasswordDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.SignInDto;
import com.mong.mmbs.dto.SignInResponseDto;
import com.mong.mmbs.dto.SignUpDto;
import com.mong.mmbs.service.AuthService;
import com.mong.mmbs.service.MailService;
import com.mong.mmbs.service.MemberService;
import com.mong.mmbs.service.UserService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
	
	@Autowired AuthService authService;
	@Autowired UserService userUpdateService;
	@Autowired MemberService memberService;
	@Autowired MailService mailService;
	
	@PostMapping("/signUp")
	public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
		ResponseDto<?> result = authService.signUp(requestBody);
		return result;
	}
	@PostMapping("/findId")
	public ResponseDto<?> findId(@RequestBody FindIdDto requestBody){
		ResponseDto<?> result = authService.findId(requestBody);
		return result;
	}
	@PostMapping("/findPassword")
	public ResponseDto<?> findPassword(@RequestBody FindPasswordDto requestBody){
		ResponseDto<?> result = authService.findPassword(requestBody);
		return result;
	}
	@PostMapping("/resetPassword")
	public ResponseDto<?> resetPassword(@RequestBody ResetPasswordDto requestBody){
		ResponseDto<?> result = authService.resetPassword(requestBody);
		return result;
	}
	@PostMapping("/signIn")
	public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
		ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
		return result;
	}
	
}
