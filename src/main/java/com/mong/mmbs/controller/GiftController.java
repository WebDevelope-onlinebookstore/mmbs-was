package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.GiftDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.service.GiftService;

@RequestMapping("/api/auth")
@RestController
public class GiftController {
	@Autowired GiftService giftService;
	@GetMapping("/gift/{giftCode}")
	public ResponseDto<?>gift(@PathVariable("giftCode")int giftCode){
		
		return giftService.gift(giftCode);
	}
	
	
	
	
	
	@PostMapping("/giftorder")
	public ResponseDto<?>giftorder(@RequestBody GiftDto requsetBody){
		return null;
	}
	

}
