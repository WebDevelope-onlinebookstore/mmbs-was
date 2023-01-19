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
@Table(name="cart")
@Entity(name="cart")
public class CartEntity {
	@Id
	private int cartId;
	private String cartUserId;
	private	int cartProductIsbn;
	private String cartProductName;
	private int	cartProductPrice;
	private int	cartProductAmount;
	private int	cartTotalPrice;
	private int cartProductStock;
	private String cartData;
}
