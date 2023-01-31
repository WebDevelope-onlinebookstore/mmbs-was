package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mong.mmbs.dto.DtlLikepageDto;
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
	
	
	
	
//	상세페이지 좋아요
	public ResponseDto<?>dtllikePage(DtlLikepageDto dto ) {
		int productSeq = dto.getProductSeq();
		System.out.println("222222");
		ProductEntity productEntity = productRepository.findByProductSeq(productSeq);
		System.out.println("3333");
		productEntity.setProductLike(productEntity.getProductLike() + 1);
		System.out.println("4444444");
		productRepository.save(productEntity);
		System.err.println("55555555");
		return ResponseDto.setSuccess("성공", null);
		
	}
	
}
