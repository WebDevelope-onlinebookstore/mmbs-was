package com.mong.mmbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.repository.ProductRepository;

@Service

public class ProductService {
	
	@Autowired ProductRepository productRepository;
	
	//연령
	
	public ResponseDto<?> getProductAgeList(String productAgeCategory, String productSubAgeCategory) {
		
		List<ProductEntity> productAgeList = null;
		
		if(productSubAgeCategory.equals("0"))
			productAgeList = productRepository.findByProductAge(productAgeCategory);
		else 
			productAgeList = productRepository.findByProductAgeAndProductSubAge(productAgeCategory, productSubAgeCategory);

		return ResponseDto.setSuccess("Success", productAgeList);
	}
		
		// 장르별		
		
	public ResponseDto<?> getProductGenreList(String productGenreCategory, String productSubGenreCategory) {
		System.out.println(productGenreCategory);
		
		List<ProductEntity> productGenreList = null; 
		
		if(productSubGenreCategory.equals("0"))
			productGenreList = productRepository.findByProductGenre(productGenreCategory);
		else 
			productGenreList = productRepository.findByProductGenreAndProductSubGenre(productGenreCategory, productSubGenreCategory);

			return ResponseDto.setSuccess("Success", productGenreList);
	}
	
}