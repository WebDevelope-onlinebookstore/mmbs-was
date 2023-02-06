package com.mong.mmbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coupon")
@Entity(name = "coupon")
public class CouponEntity {
//	쿠폰 코드
	@Id
	private String couponCode;
//  쿠폰 이름
    private String couponName;
//  쿠폰 종류
    private String couponClass;
//  혜택가
    private String couponBenefit;
//  쿠폰 설명
    private int couponDescription;
//  쿠폰 이미지
    private String strcouponImage;

}
