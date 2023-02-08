package com.mong.mmbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.mong.mmbs.dto.ResponseDto;
import com.mong.mmbs.entity.ProductEntity;
import com.mong.mmbs.repository.ProductRepository;

@Service
public class BestsellerService {
    
    @Autowired ProductRepository productRepository;

    public ResponseDto<?> Bestseller (){
        List<ProductEntity> ProductBast = productRepository.findTop10ByOrderByProductLikeDesc();
        
        return ResponseDto.setSuccess("성공", ProductBast);
    }

    public ResponseDto<?> MainImage(){
        List<ProductEntity> BastImage = productRepository.findAll();

        return ResponseDto.setSuccess("성공", BastImage);
    }


}
