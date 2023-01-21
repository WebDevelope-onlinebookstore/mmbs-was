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
//	아이디
	@Id
	private String userId;
//	비밀번호
	private String userPassword;
//	이메일
	private String userEmail;
//	주소
	private String userAddress;
//	상세 주소
	private String userAddressDetail;
//	이름
	private String userName;
//	전화번호
	private String userPhone;
//	등급
	private String userGrade;
//	누적 금액
	private int userTotalAmount;
//	아이 생일
	private String userKidBirth;
//	가입 날짜
	private String userSignUpDate;
//	탈퇴 날짜
	private String userWithdraw;
	  
}
