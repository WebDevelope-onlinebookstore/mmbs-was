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
public class UserEntity {
	@Id
	 private String userId;
	  private String userPassword;
	  private String userName;
	  private String userPhone;
	  private String userEmail;
	  private String userAddressApi;
	  private String userAddressDtl;
	  private String userGrade;
	  private int userTotalAmount;
	  private int userRecommend;
	  private String userKidBirth;
	  private String userSignupDate;
	  private String userWithdraw;
	  private String struserCoupon;
}
