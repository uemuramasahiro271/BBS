package com.bbs.app.postpage.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContentForm implements Serializable {

	private int bbsId;
	private int no;
	private String contributor;
	private String text;
}
