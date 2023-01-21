package com.mong.mmbs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
@Entity(name="product")
public class ProductEntity {
//	고유번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_seq;
//	장르 [국내도서, 외국도서, 전집, 토이/교구, 부모님의 서재]
	private String productGenre;
//	고유번호
	private int productIsbn;
//	제목
	private String productTitle;
//	저자
	private String productWriter;
//	출판사
	private String productPublisher;
//	연령 [0~3세, 4~7세, 부모]
	private String productAge;
//	출판일
	private String productPublicationDate;
//	가격
	private int productPrice;
//	할인가격
	private int productSalesPrice;
//	재고
	private int productStock;
//	좋아요
	private int productLike;
//	입고일
	private String productStockingDate;
//	상세 설명
	private String productIntroduceDtl;
//	간단한 설명
	private String productIntroduce;
//	이미지
	private String productImageUrl;
//	판매량
	private int productSalesCount;
}
