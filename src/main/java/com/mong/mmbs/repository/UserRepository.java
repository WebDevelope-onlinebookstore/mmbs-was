package com.mong.mmbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mong.mmbs.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	public boolean existsByUserEmail(String userEmail);
	
	public boolean existsByUserIdAndUserPassword(String userId, String userPassword);
	
	public UserEntity findByUserId(String UserId);
}
