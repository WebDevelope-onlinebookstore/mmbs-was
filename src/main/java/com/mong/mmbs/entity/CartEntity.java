package com.mong.mmbs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mong.mmbs.dto.AmountUpdateDto;
import com.mong.mmbs.dto.PutInCartDto;

import com.mong.mmbs.dto.SignUpDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
@Entity(name = "cart")
public class CartEntity {
//  카트 시퀀스
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
//  유저 아이디
	private String cartUserId;
//  제품 아이디
	private int cartProductId;
//  제품 이름
	private String cartProductName;
//  제품 이미지
	private String cartProductImage;
//  제품 개당 가격
	private int cartProductPrice;
//  제품 개 수
	private int cartProductAmount;
	
	public CartEntity(PutInCartDto dto) {
		this.cartUserId = dto.getCartUserId();
		this.cartProductId = dto.getCartProductId();
		this.cartProductName = dto.getCartProductName();
		this.cartProductImage = dto.getCartProductImage();
		this.cartProductPrice = dto.getCartProductPrice();
		this.cartProductAmount = dto.getCartProductAmount();
	}
//	public CartEntity AmountUpdate(PutInCartDto dto) {
//		this.cartProductAmount = dto.getCartProductAmount();
//		return CartEntity.builder().cartProductAmount(cartProductAmount).build();
//	}
//	public CartEntity AmountUpdate(AmountUpdateDto dto) {
//		return CartEntity.builder().cartProductAmount(getCartProductAmount()).build();
//	}
	
	
}
