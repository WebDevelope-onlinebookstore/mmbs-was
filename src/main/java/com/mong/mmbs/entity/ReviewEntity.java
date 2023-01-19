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
@Table(name="review")
@Entity(name="review")
public class ReviewEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private String reviewWriter;
	private int orderNumber;
	private String reviewTitle;
	private String reviewContent;
	private String reviewDate;
	private String reviewStatus;
	private String reviewDelete;
}
