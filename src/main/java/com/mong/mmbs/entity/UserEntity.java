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
@Table(name="user")
@Entity(name="user")
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
	  private String userRecommend;
	  private String userKidBirth;
	  private String userSignUpDate;
	  private String userWithdraw;
	  private String userCoupon;
}
