package com.mong.mmbs.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
	@NotBlank
	private String userId;
	@NotBlank
	private String userPassword;
	@NotBlank
	private String userPasswordCheck;
	@NotBlank
	private String userName;
	@NotBlank
	private String userPhone;
	@NotBlank
	private String userEmail;
	@NotBlank
	private String userAddress;
	@NotBlank
	private String userAddressDetail;
	private String userKidBirth;
	private String recommendedUserId;
}