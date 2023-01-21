package com.mong.mmbs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orderDetail")
@Entity(name="orderDetail")
public class OrderDetailEntity {
//	주문상세 시퀀스
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailSeq;
//	주문번호
	private String orderNumber;
//	제품 아이디
	private String productId;
//	개당 금액
	private int productPrice;
//	갯수
	private int orderCount;
}
