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
@Table(name="review")
@Entity(name="review")
public class ReviewEntity {
	@Id
	private int reviewId;
	private String reviewWriter;
	private int orderNumber;
	private String reviewTitle;
	private String reviewContent;
	private String reviewDate;
	private String reviewStatus;
	private String reviewDelete;
}
