package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.OrderEntity;
import com.mong.mmbs.repository.OrderDetailRepository;
import com.mong.mmbs.repository.OrderRepository;

@Service
public class OrderInquiryService {
	
	@Autowired OrderRepository orderRepository;
	@Autowired OrderDetailRepository orderDetailRepository;
	
	public ResponseDto<?> getOrderInquiry(Integer orderNumber) {
		OrderEntity order = null;
		
		try {
			order = orderRepository.findByOrderNumber(orderNumber);
		} catch (Exception exception) {
			return ResponseDto.setFailed("Database Error");
		}
		return ResponseDto.setSuccess("Success", order);
	}
}
