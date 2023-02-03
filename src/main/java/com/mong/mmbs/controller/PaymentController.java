package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.OrderDto;
import com.mong.mmbs.service.UserService;
import com.mong.mmbs.service.OrderService;

@RestController
@RequestMapping("/api")
public class PaymentController {
	
@Autowired UserService userService;
@Autowired OrderService orderService;
	
	@GetMapping("/paymentInfo/{userId}")
	public ResponseDto<?> getUser(@PathVariable("userId")String userId) {
		return userService.getUser(userId);
	}

	@PostMapping("/orderInfo")
	public ResponseDto<?> orderInfo(@RequestBody OrderDto requestBody) {
		ResponseDto<?> result = orderService.orderInfo(requestBody);
		return result;
	}
}
