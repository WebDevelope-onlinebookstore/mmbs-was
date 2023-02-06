package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.CouponEntity;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, String>{

}
