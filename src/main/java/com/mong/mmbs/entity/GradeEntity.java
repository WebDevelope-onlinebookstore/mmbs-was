package com.mong.mmbs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grade")
@Entity(name = "grade")
public class GradeEntity {
//	등급 아이디 [0, 1, 2, 3, 4]
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gradeId;
//	등급 이름 [씨앗, 새싹, 풀잎, 나무, 열매]
	private String gradeName;
//  할인율 [0, 3, 5, 7, 10]
	private int gradeDiscount;
//	준 누적 금액 [0, 10, 30, 50, 70]
	private int gradeTotalPrice;

}
