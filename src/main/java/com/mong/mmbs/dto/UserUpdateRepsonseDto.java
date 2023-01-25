package com.mong.mmbs.dto;

import com.mong.mmbs.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRepsonseDto {
	private String token;
	private int exprTime;
	private UserEntity user;
}
