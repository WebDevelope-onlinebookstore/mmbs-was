package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.OrderpaymentEntity;

@Repository
public interface OrderpaymentRepository extends JpaRepository<OrderpaymentEntity, Integer>{

}
