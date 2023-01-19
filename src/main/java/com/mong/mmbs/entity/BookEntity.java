package com.mong.mmbs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class BookEntity {
	@Id
	 private int bookIsbn;
	 private String bookTitle;
	 private String bookWriter;
	 private String bookPublisher;
	 private String bookAge;
	 private String bookGenre;
	 private String bookPublicationDate;
	 private int bookPrice;
	 private int bookSalesPrice;
	 private int bookStock;
	 private int bookLike;
	 private String bookStockingDate;
	 private String bookIntroduce;
	 private String bookImageUrl;
}
