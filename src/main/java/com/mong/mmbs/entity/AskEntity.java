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
@Table(name="ask")
@Entity(name="ask")
public class AskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int askId;
	private String askWriter;
	private String askTitle;
	private String askSort;
	private String askContent;
	private String askData;
	private String askStatus;
	private String askDelete;
}
