package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.DeleteFromCartDto;
import com.mong.mmbs.dto.PutInCartDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.service.AuthService;
import com.mong.mmbs.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired CartService cartService;
	@PostMapping("/cartInsert")//담는거
	public ResponseDto<?> putInCart(@RequestBody PutInCartDto requestBody){
		System.out.println(requestBody.toString());
		ResponseDto<?> result = cartService.putInCart(requestBody);
		return result;
	}
	@PostMapping("/cartDelete")//지우는거
	public ResponseDto<?> deleteFromCart(@RequestBody DeleteFromCartDto requestBody){
		ResponseDto<?> result = cartService.deleteFromCart(requestBody);
		return result;
	}
}
