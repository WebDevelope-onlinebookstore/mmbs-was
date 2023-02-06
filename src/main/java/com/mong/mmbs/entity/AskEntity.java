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
@Table(name = "ask")
@Entity(name = "ask")
public class AskEntity {
//  문의 번호
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int askId;
//  작성자 아이디 (참조)
	private String askWriter;
//  문의 카테고리
	private String askSort;
//  문의 내용
	private String askContent;
//  문의 날짜
	private String askDatetime;
//  문의 상태 [-1: 삭제, 0: 문의 접수, 1: 답변완료 상태]
	private int askStatus;
//  문의 답변
    private String askReply;
}
