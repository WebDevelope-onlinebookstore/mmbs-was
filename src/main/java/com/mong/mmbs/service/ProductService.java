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
		// 0~3
		if (productAgeCategory.equals("1")) {
			for(Integer i = 0; i<6; i++) {
				if
//				(i==0) {
//					productAgeList = productRepository.findByProductAge(productAgeCategory);
//				}
//			else
				(productSubAgeCategory.equals(i.toString())) {
					productAgeList = productRepository.findByProductAgeAndProductSubAge(productAgeCategory, productSubAgeCategory);
				}
			}
		} // 4~7
		else if (productAgeCategory.equals("2")) {
			for(Integer i = 0; i<6; i++) {
				if(productSubAgeCategory.equals(i.toString())) {
					productAgeList = productRepository.findByProductAgeAndProductSubAge(productAgeCategory, productSubAgeCategory);
				}
			}
		}
		return ResponseDto.setSuccess("Success", productAgeList);
	}
		
		// 장르별		
		
	public ResponseDto<?> getProductGenreList(String productGenreCategory, String productSubGenreCategory) {
		System.out.println(productGenreCategory);
		
		List<ProductEntity> productGenreList = null; 
			if (productGenreCategory.equals("국내도서")) {
				for(Integer i = 0; i<7; i++) {
					if(productSubGenreCategory.equals(i.toString())) {
						productGenreList = productRepository.findByProductGenreAndProductSubGenre(productGenreCategory, productSubGenreCategory);
					}
				}
			}
			else if (productGenreCategory.equals("해외도서")) {
				for(Integer i = 0; i<5; i++) {
					if(productSubGenreCategory.equals(i.toString())) {
						productGenreList = productRepository.findByProductGenreAndProductSubGenre(productGenreCategory, productSubGenreCategory);
					}
				}
			}
			else if (productGenreCategory.equals("전집")) {
				for(Integer i = 0; i<6; i++) {
					if(productSubGenreCategory.equals(i.toString())) {
						productGenreList = productRepository.findByProductGenreAndProductSubGenre(productGenreCategory, productSubGenreCategory);
					}
				}
			}
			else if (productGenreCategory.equals("부모님의 서재")) {
				for(Integer i = 0; i<5; i++) {
					if(productSubGenreCategory.equals(i.toString())) {
						productGenreList = productRepository.findByProductGenreAndProductSubGenre(productGenreCategory, productSubGenreCategory);
					}
				}
			}
			else if (productGenreCategory.equals("토이/놀이")) {
				for(Integer i = 0; i<4; i++) {
					if(productSubGenreCategory.equals(i.toString())) {
						productGenreList = productRepository.findByProductGenreAndProductSubGenre(productGenreCategory, productSubGenreCategory);
					}
				}
			}
			return ResponseDto.setSuccess("Success", productGenreList);
		}

		public ResponseDto<?> getProduct(int productSeq) {
			ProductEntity product = null;
			try {
				product = productRepository.findByProductSeq(productSeq);
			} catch (Exception exception) {
				return ResponseDto.setFailed("failed");
			}
			return ResponseDto.setSuccess("success", product);
		}
	
	}

//나이와 장르를 합쳐서 하는 방법

//public ResponseDto<?> getBookList(String productCategory, String productSubCategory) {
//	
//	List<ProductEntity> productList = null;
//	if (productCategory.equals("1") || productCategory.equals("2"))
//		productList = productRepository.findByProductAgeAndProductAgeCategory(productCategory, productSubCategory);
//	else 
//		productList = productRepository.findByProductGenreAndProductGenreCategory(productCategory, productSubCategory);
//	
//	return ResponseDto.setSuccess("Success", productList);
//}