package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.OrderEntity;
import com.mong.mmbs.entity.ProductEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

	public OrderEntity findByOrderNumber(int orderNumber);
}
