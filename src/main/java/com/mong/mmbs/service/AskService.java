package com.mong.mmbs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.dto.AskDto;
import com.mong.mmbs.dto.AskUpdateDto;
import com.mong.mmbs.repository.AskRepository;
import com.mong.mmbs.entity.AskEntity;

@Service
public class AskService {

  @Autowired AskRepository askRepository;

  // 로그인 된 회원의 아이디를 askWriter에 입력
  // 문의 유형는 제품 문의, 주문/결제 문의, 취소/환불 문의 3가지
  // 문의 상태는 [-1: 삭제, 0: 문의 접수, 1: 답변완료 상태]
  public ResponseDto<?> getAskList(String userId) {

		List<AskEntity> askList = new ArrayList<AskEntity>();

		try {
			askList = askRepository.findByAskWriter(userId);
			if (askList == null) return ResponseDto.setFailed("Does not Exist Order");
		} catch(Exception exception){
			return ResponseDto.setFailed("Database Error");
		}
		return ResponseDto.setSuccess("Success", askList);
	}

	public ResponseDto<?> askWrite(AskDto dto){

		AskEntity askEntity = new AskEntity(dto);
		try {
			System.out.println(askEntity.toString());
			askRepository.save(askEntity);
		} catch (Exception exception) {
			return ResponseDto.setFailed("Failed");
		}
		return ResponseDto.setSuccess("Ask Write Success", askEntity);

	}

	public ResponseDto<?> askUpdateList(int askId){
		
		AskEntity ask = null;

		try {
			ask = askRepository.findByAskId(askId);
		} catch (Exception exception) {
			return ResponseDto.setFailed("Database Error");
		}
		return ResponseDto.setSuccess("성공", ask);
	}

	public ResponseDto<?> askUpdate(AskUpdateDto dto) {
		AskEntity ask = null;
		int askId = dto.getAskId();

		try {
			ask = askRepository.findByAskId(askId);
			if (ask == null) ResponseDto.setFailed("Does Not Exist User");
		} catch (Exception exception) {
			ResponseDto.setFailed("Failed");
		}

		System.out.println("================================");
		System.out.println(ask.toString());
		ask.setAskUpdate(dto);
		System.out.println("================================");
		System.out.println(ask.toString());
		try {
			askRepository.save(ask);
		} catch (Exception exception) {
			ResponseDto.setFailed("Failed");
		}
		
		return ResponseDto.setSuccess("Success", ask);
	}
}
