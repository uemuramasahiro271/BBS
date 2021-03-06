package com.bbs.app.postpage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bbs.app.selection_bbs.entity.BbsEntity;

import lombok.Data;

@Entity
@Data
@Table(name = "contents")
public class ContentEntity implements Serializable {

	@EmbeddedId
	private ContentPk contentPk;

	@Column(name = "contributor")
	private String contributor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;

	@Column(name = "text")
	private String text;

	@ManyToOne(optional = true)
	@JoinColumn(name = "bbs_id", referencedColumnName = "id")
	@MapsId("bbsId")
	private BbsEntity bbsEntity;
}
