package com.mong.mmbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.GetOrderInquiryResponseDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.OrderDetailEntity;
import com.mong.mmbs.entity.OrderEntity;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.repository.OrderDetailRepository;
import com.mong.mmbs.repository.OrderRepository;
import com.mong.mmbs.repository.ProductRepository;

@Service
public class OrderInquiryService {
	
	@Autowired OrderRepository orderRepository;
	@Autowired OrderDetailRepository orderDetailRepository;
	@Autowired ProductRepository productRepository;

	// 로그인 된 회원의 userId로 Orders테이블에서 주문리스트 반환
	public ResponseDto<?> getList(String userId) {

		List<OrderEntity> orderList = new ArrayList<OrderEntity>();

		try {
			orderList = orderRepository.findByOrderUserId(userId);
			if (orderList == null) return ResponseDto.setFailed("Does not Exist Order");
		} catch(Exception exception){
			return ResponseDto.setFailed("Database Error");
		}
		return ResponseDto.setSuccess("Success", orderList);
	}
	
	// 
	public ResponseDto<?> getOrderInquiry(String orderNumber, int productSeq) {

		OrderEntity order = null;
		ProductEntity product = null;
		// 해당 주문의 상세 데이터 리스트 같이 반환
		List<OrderDetailEntity> detailList= new ArrayList<OrderDetailEntity>();
		// 해당 주문의 제품 리스트 같이 반환
		// List<ProductEntity> productList= new ArrayList<ProductEntity>();

		try {
			order = orderRepository.findByOrderNumber(orderNumber);
			detailList = orderDetailRepository.findByOrderNumber(orderNumber);
			product = productRepository.findByProductSeq(productSeq);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed("Database Error");
		}
		GetOrderInquiryResponseDto getOrderInquiryResponseDto = new GetOrderInquiryResponseDto(order, detailList, product);
		return ResponseDto.setSuccess("Suceess" , getOrderInquiryResponseDto);
	}

}
