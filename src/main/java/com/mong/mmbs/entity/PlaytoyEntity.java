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
public class PlaytoyEntity {
	@Id
	private int playtoyId;
	private String playtoyTitle;
	private String strplaytoyAge;
	private String playtoyGenre;
	private String playtoyPublicationDate;
	private int playtoyPrice;
	private int playtoySalesPrice;
	private int playtoyStock;
	private int playtoyLike;
	private String playtoyStockingDate;
	private String playtoyIntroduce;
	private String playtoyImageUrl;
}
