package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.repository.OrderDetailRepository;
import com.mong.mmbs.repository.OrderRepository;
import com.mong.mmbs.repository.ProductRepository;
import com.mong.mmbs.dto.OrderDto;
import com.mong.mmbs.entity.OrderEntity;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.entity.OrderDetailEntity;

@Service
public class OrderService {

  @Autowired OrderRepository orderRepository;
  @Autowired OrderDetailRepository orderDetailRepository;
  @Autowired ProductRepository productRepository;

  public ResponseDto<?> orderInsert(OrderDto dto){

    int productId  = dto.getProductId();
    ProductEntity product = null;
    
    try {
      product = productRepository.findByProductSeq(productId);
      if (product == null) return ResponseDto.setFailed("Does Not Exists Product");
    } catch (Exception exception) {
      return ResponseDto.setFailed("DataBase Error");
    }
    
    OrderEntity order = new OrderEntity(dto, product);
    System.out.println(order.toString());

    try {
      orderRepository.save(order);
    } catch (Exception exception) {
      return ResponseDto.setFailed("DataBase Error");
    }

    int a = 0;
    if (a == 1) {

    } else 
    if (a == 2) {

      } else {

      }

    OrderDetailEntity orderDetail = new OrderDetailEntity(dto, order, product);
    try {
      orderDetailRepository.save(orderDetail);
    } catch (Exception exception) {
      return ResponseDto.setFailed("DataBase Error");
    }
    return ResponseDto.setSuccess("result", orderDetail);

  }
}
