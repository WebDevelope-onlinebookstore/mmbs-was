package com.mong.mmbs.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PutInCartDto {

	// 3개만 가지고오는이유
	// cartUserId/cartProductId는 무슨값들을 가지고있는지

	// 지금 cartUserId에는user.userId 값을 들고있음
	@NotBlank
	private String cartUserId;
	// 지금 cartProductId에는 productSeq 값을 들고있음
	@NotBlank
	 private int cartProductId;
	// @NotBlank
	// private String cartProductName;
	// @NotBlank
	// private String cartProductImage;
	// @NotBlank
	// private int cartProductPrice;
	@NotBlank
	private int cartProductAmount;
}