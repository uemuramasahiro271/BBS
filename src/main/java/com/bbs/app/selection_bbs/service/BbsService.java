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

	@Transactional
	public List<BbsEntity> findAll() {
		return bbsRepository.findAll();
	}

	@Transactional
	public List<BbsEntity> findBbs(String titleCondition) {
		return bbsRepository.findBbs(titleCondition);
	}

	@Transactional
	public Optional<BbsEntity> findById(int id) {
		return bbsRepository.findById(id);
	}

	@Transactional
	public List<ContentEntity> getContents(int id) {

		return findById(id)
				.map(entity -> entity.getContents())
				.orElseGet(() -> { return new ArrayList<ContentEntity>(); });
	}

	@Transactional
	public int getCurrentNo(int id) {
		return findById(id)
				.map(entity -> entity.getCurrentNo())
				.orElseGet(() -> 1);
	}

	public BbsEntity createBbs(String title) {
		var entity = new BbsEntity();
		entity.setTitle(title);
		var result = bbsRepository.save(entity);

		return result;
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

	public List<BbsEntity> delete(List<Integer> ids) {
		List<BbsEntity> deleteList = new ArrayList<BbsEntity>();
		for(var id : ids) {
			var bbsEntity = bbsRepository.findById(id).get();
			deleteList.add(bbsEntity);
		}
		bbsRepository.deleteAll(deleteList);

		return deleteList;
	}
}
