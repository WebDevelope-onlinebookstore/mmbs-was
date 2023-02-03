package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.UserUpdateDto;
import com.mong.mmbs.entity.UserEntity;
import com.mong.mmbs.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository userRepository;
	
    public ResponseDto<?> getUser(String userId) {
    	UserEntity user = null;
    	try {
    		user = userRepository.findByUserId(userId);
    	} catch (Exception exception) {
    		return ResponseDto.setFailed("Database Error");
    	}
    	
    	if (user != null) user.setUserPassword("");
    	
    	return ResponseDto.setSuccess("result", user);
    }
    
	public ResponseDto<?> userUpdate(UserUpdateDto dto){
		
		UserEntity user = null;
		
		try {
			user = userRepository.findByUserId(dto.getUserId());
			if (user == null) ResponseDto.setFailed("Does Not Exist User");
		} catch (Exception exception) {
			ResponseDto.setFailed("Failed");
		}
		
		user.setUpdateUser(dto);
		
		try {
			userRepository.save(user);
		} catch (Exception exception) {
			ResponseDto.setFailed("Failed");
		}
		
		return ResponseDto.setSuccess("Sucess", user);
	}
}
//public ResponseDto<UserUpdateResponseDto> userUpdate(UserUpdateDto dto) {
//return null;
////회원 정보 수정 (userId, userEmail는 변경 불가)
////로그인 된 회원만 접근 가능
////로그인 된 'userId'로 회원 정보 불러오기
////비밀번호는 가져오지 않는다.
////비밀번호 양식이 맞는지 검증
////비밀번호 변경 시 확인란과 서로 같은지 검증
////수정된 회원 정보 저장 및 출력
//}