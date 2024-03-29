package com.mong.mmbs.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AskDto {
  @NotBlank
	private String askWriter;
  @NotBlank
  private String askSort;
  @NotBlank
  private String askTitle;
  @NotBlank
	private String askContent;
}
