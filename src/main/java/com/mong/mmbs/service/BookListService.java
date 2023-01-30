package com.mong.mmbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.repository.ProductRepository;

@Service

public class BookListService {
	
	@Autowired ProductRepository productRepository;
	
	public ResponseDto<?>getBookList() {
		List<ProductEntity> productList = productRepository.findAll();
		
		return ResponseDto.setSuccess("Success", productList);
	}
}
