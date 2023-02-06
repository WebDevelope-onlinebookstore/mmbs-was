package com.mong.mmbs.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	@NotBlank
	private String orderNumber;
//	회원여부
	private boolean orderUserWhether;
//	비회원 비밀번호
	private String orderGuestPassword;
//	회원 아이디
	private String orderUserId;
//	사은품
	private int giftCode;
	@NotBlank
	private String orderUserName;
	@NotBlank
	private String orderUserPhone;
	@NotBlank
	private String orderUserEmail;
	@NotBlank
	private String orderDatetime; // datetime
	@NotBlank
	private String orderRecieptName;
	@NotBlank
	private String orderRecieptPhone;
	@NotBlank
	private String orderShipAddress; // text
	@NotBlank
	private String orderShipAddressDetail; // text
	// @NotBlank
	// private int orderTotalPrice;
	// @NotBlank
	// private int orderStatus;
	// @NotBlank
	// private String orderShipCompany;
	@NotBlank
	private int orderShipNumber;
}
