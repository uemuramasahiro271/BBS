package com.bbs.app.selection_bbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.app.postpage.entity.ContentEntity;
import com.bbs.app.selection_bbs.entity.BbsEntity;
import com.bbs.app.selection_bbs.repository.BbsRepository;


@Service
public class BbsService {

	@Autowired
	private BbsRepository bbsRepository;

	public List<BbsEntity> findAll() {
		return bbsRepository.findAll();
	}

	public Optional<BbsEntity> findById(int id) {
		return bbsRepository.findById(id);
	}

	public List<ContentEntity> getContents(int id) {

		return findById(id)
				.map(entity -> entity.getContents())
				.orElseGet(() -> { return new ArrayList<ContentEntity>(); });
	}

	public int getCurrentNo(int id) {
		return findById(id)
				.map(entity -> entity.getCurrentNo())
				.orElseGet(() -> 1);
	}

	@Transactional
	public void update(BbsEntity entity) {
		bbsRepository.save(entity);
	}

	@Transactional
	public void updateCurrentNo(int id, int no) {
		var entity = findById(id).get();
		entity.setCurrentNo(no);
		bbsRepository.save(entity);
	}
}
