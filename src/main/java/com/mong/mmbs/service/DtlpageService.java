package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.repository.ProductRepository;

@Service
public class DtlpageService {

	
	@Autowired ProductRepository productRepository;
	
	public ResponseDto<?>dtlPage(int productSeq){
		
		ProductEntity product=productRepository.findByProductSeq(productSeq);
		
		return ResponseDto.setSuccess("성공", product);
	}
	
}
