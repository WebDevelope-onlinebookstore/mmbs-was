package com.mong.mmbs.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.mong.mmbs.dto.AskDto;

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
	@NotBlank
	private String askWriter;
//  문의 카테고리
	@NotBlank
	private String askSort;
//  문의 내용
	@NotBlank
	private String askContent;
//  문의 날짜
	private String askDatetime;
//  문의 상태 [-1: 삭제, 0: 문의 접수, 1: 답변완료 상태]
	private int askStatus;
//  문의 답변
    private String askReply;

		public AskEntity(AskDto dto){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			askWriter = dto.getAskWriter();
			askSort = dto.getAskSort();
			askContent = dto.getAskContent();
			askDatetime = dateFormat.format(new Date());
		}
}
