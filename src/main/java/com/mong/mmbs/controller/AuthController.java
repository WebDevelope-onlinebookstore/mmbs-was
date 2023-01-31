package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.DeleteFromCartDto;
import com.mong.mmbs.dto.FindIdDto;
import com.mong.mmbs.dto.FindPasswordDto;
import com.mong.mmbs.dto.PutInCartDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.SignInDto;
import com.mong.mmbs.dto.SignInResponseDto;
import com.mong.mmbs.dto.SignUpDto;
import com.mong.mmbs.dto.UserUpdateDto;
import com.mong.mmbs.service.AuthService;
import com.mong.mmbs.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired AuthService authService;
	@Autowired UserService userUpdateService;
	
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
	
	@PostMapping("/signIn")
	public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
		ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
		return result;
	}
	
//	@PostMapping("/userUpdate")
//	public ResponseDto<UserUpdateReponseDto> userUpdate(@RequestBody UserUpdateDto requestBody) {
//		ResponseDto<UserUpdateReponseDto> result = authService.userUpdate(requestBody);
//		return result;
//	}
	
	
//	@GetMapping("/userUpdate/{userId}")
//	public ResponseDto<?> userUpdate(@PathVariable("userId") String userId) {
//		return userUpdateService.userUpdate(userId);
//		return null;
//	}
	
//	@PostMapping("/userUpdate/{userId}")
//	public ResponseDto<?> userUpdatea(@RequestBody UserUpdateDto requestBody) {
////		ResponseDto<?> result = authService.
//		return null;
//	}
}
