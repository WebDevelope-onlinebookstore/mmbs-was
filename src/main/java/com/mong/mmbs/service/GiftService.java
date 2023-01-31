package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.GiftDto;
import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.GiftEntity;
import com.mong.mmbs.entity.OrderEntity;
import com.mong.mmbs.repository.GiftRepository;
import com.mong.mmbs.repository.OrderRepository;
import com.mong.mmbs.repository.UserRepository;

import java.util.List;

@Service
public class GiftService {
	@Autowired GiftRepository giftRepository;
	@Autowired OrderRepository orderRepository;
	public ResponseDto<?>gift(int giftcode){
		List<GiftEntity>result =giftRepository.findAll();
		return ResponseDto.setSuccess("성공", result);
	}
	
	
	
	
	
	
	
	
	public ResponseDto<?>giftorder(GiftDto dto){
		int GiftCode = dto.getGiftCode();
		OrderEntity orderEntity = OrderEntity
				.builder().giftCode(GiftCode)
				.build();
				orderRepository.save(orderEntity);
		return null;
				
	}
}