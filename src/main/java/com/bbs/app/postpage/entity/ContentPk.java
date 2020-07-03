package com.bbs.app.postpage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentPk implements Serializable {

	@Column(name = "bbs_id")
	private int bbsId;

	@Column(name = "no")
	private int no;
}
