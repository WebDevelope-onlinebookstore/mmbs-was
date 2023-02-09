package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.OrderEntity;

@Repository
public interface TrackingRepository extends JpaRepository<OrderEntity, String> {
	
public OrderEntity findByOrderNumber(OrderEntity tracking);

}
