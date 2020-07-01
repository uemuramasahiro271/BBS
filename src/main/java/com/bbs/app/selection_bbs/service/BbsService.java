package com.bbs.app.selection_bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.app.selection_bbs.entity.BbsEntity;
import com.bbs.app.selection_bbs.repository.BbsRepository;


@Service
public class BbsService {

	@Autowired
	private BbsRepository bbsRepository;

	public List<BbsEntity> findAll() {
		return bbsRepository.findAll();
	}
}
