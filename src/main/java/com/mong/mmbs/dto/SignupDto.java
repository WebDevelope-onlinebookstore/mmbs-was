package com.mong.mmbs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupDto {
	private String userId;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userAddressApi;
	private String userAddressDtl;
	private String userRecommend;
	private String userKidBirth;
}