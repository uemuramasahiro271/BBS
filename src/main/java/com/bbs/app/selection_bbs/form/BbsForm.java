package com.bbs.app.selection_bbs.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class BbsForm implements Serializable {

	private int id;
	private String title;
	private int currentNo;
	private String updateTime;
	private int postCount;
}
