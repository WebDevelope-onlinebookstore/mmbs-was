package com.mong.mmbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class OrderpaymentEntity {
	@Id
	private int orderNumber;
	private String orderUserId;
	private int orderProductIsbn;
	private String orderMemberName;
	private String orderMemberPhone;
	private String orderMemberEmail;
	private String orderProductTitle;
	private int orderProductPrice;
	private int orderProductAmount;
	private int orderTotalPrice;
	private String orderDate;
	private String orderRecipient;
	private String orderRecieptPhone;
	private String orderShipAddress;
	private int orderShipPrice;
	private int orderShipNumber;
	private String orderShipStatus;
	private String orderShipMessage;
}
