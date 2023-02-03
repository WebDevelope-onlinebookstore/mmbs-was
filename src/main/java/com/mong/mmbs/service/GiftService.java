package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.GiftDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.GiftEntity;
import com.mong.mmbs.entity.OrderEntity;
import com.mong.mmbs.repository.GiftRepository;
import com.mong.mmbs.repository.OrderRepository;

import java.util.List;

@Service
public class GiftService {
	@Autowired GiftRepository giftRepository;
	@Autowired OrderRepository orderRepository;
	public ResponseDto<?>gift(){
		List<GiftEntity> result =giftRepository.findAll();
		return ResponseDto.setSuccess("성공", result);
	}
	
	public ResponseDto<?>giftorder(GiftDto dto){
		int GiftCode = dto.getGiftCode();
		int orderNumber = 10;

		OrderEntity orderEntity = orderRepository.findByOrderNumber(orderNumber);
		orderEntity.setGiftCode(GiftCode);

		orderRepository.save(orderEntity);
				
		return ResponseDto.setSuccess("성공", orderEntity);
				
	}
}
