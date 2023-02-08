package com.mong.mmbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.service.OrderInquiryService;

@RestController
@RequestMapping("/api/order")
// http://localhost:4080/api/order/**
public class OrderInquiryController {
	
@Autowired OrderInquiryService orderInquiryService;

	@GetMapping("/list")
	public ResponseDto<?> getList(@AuthenticationPrincipal String userId) { 
		return orderInquiryService.getList(userId);
	}

	// http://localhost:4080/api/order/orderInquiryPage/~
	@GetMapping("/orderInquiryPage/{orderNumber}/{productSeq}")
	public ResponseDto<?> getOrderInquiry(@PathVariable("orderNumber") String orderNumber, @PathVariable("productSeq") String productSeq) {
		return orderInquiryService.getOrderInquiry(orderNumber, productSeq);
	}
}
