package com.mong.mmbs.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mong.mmbs.dto.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
@Entity(name="orders")
@Builder
public class OrderEntity {
//	주문번호 uuid
	@Id
	private String orderNumber;
//	회원여부
	private boolean orderUserWhether;
//	비회원 비밀번호
	private String orderGuestPassword;
//	회원 아이디xx
	private String orderUserId;
//	사은품
	private int giftCode;
//	주문자 이름
	private String orderUserName;
//	주문자 전화번호
	private String orderUserPhone;
//	주문자 이메일
	private String orderUserEmail;
//	주문 날짜
	private String orderDatetime; //datetime
//	수령인 이름
	private String orderRecieptName;
//	수령인 전화 번호
	private String orderRecieptPhone;
//	수령인 주소
	private String orderShipAddress; //text
//	수령인 상세 주소
	private String orderShipAddressDetail; // text
//	최종 결제 금액
	private int orderTotalPrice;
//	주문 상태
	private int orderStatus;
//	배송 회사
	private String orderShipCompany;
//	송장번호
	private int orderShipNumber;
//	배송 메세지
	private String orderShipMessage; // text

	public OrderEntity(OrderDto dto) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		this.orderNumber = dto.getOrderNumber();
		this.orderUserName = dto.getOrderUserName();
		this.orderUserPhone = dto.getOrderUserPhone();
		this.orderUserEmail = dto.getOrderUserEmail();
		this.orderRecieptName = dto.getOrderRecieptName();
		this.orderRecieptPhone =dto.getOrderRecieptPhone();
		this.orderShipAddress = dto.getOrderShipAddress();
		this.orderShipAddressDetail = dto.getOrderShipAddressDetail();
		this.orderDatetime = dateFormat.format(new Date());
	}
}
