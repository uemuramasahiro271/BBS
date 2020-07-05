package com.bbs.app.postpage.form;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentForm implements Serializable {

	@JsonProperty("id")
	private int bbsId;
	private int no;
	private String contributor;
	private String date;
	private String text;
}
