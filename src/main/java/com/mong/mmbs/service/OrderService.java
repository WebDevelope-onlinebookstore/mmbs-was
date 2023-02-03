package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.repository.OrderRepository;
import com.mong.mmbs.dto.OrderDto;
import com.mong.mmbs.entity.OrderEntity;

@Service
public class OrderService {

  @Autowired OrderRepository orderRepository;

  public ResponseDto<?> orderInfo(OrderDto dto){

    OrderEntity order = new OrderEntity(dto);
    try {
      order = orderRepository.save(order);
    } catch (Exception exception) {
      ResponseDto.setFailed("DataBase Error");
    }

    return ResponseDto.setSuccess("result", order);
  }

}
