package com.bbs.app.selection_bbs.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bbs.app.postpage.entity.ContentEntity;

import lombok.Data;

@Entity
@Data
@Table(name = "bbs")
public class BbsEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "current_no")
	private int currentNo;

	@OneToMany(mappedBy = "bbs", orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "bbsId")
	private List<ContentEntity> contents;
}
