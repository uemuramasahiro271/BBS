package com.bbs.app.postpage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.app.postpage.entity.ContentEntity;
import com.bbs.app.postpage.entity.ContentPk;
import com.bbs.app.postpage.repository.PostPageRepository;
import com.bbs.app.selection_bbs.repository.BbsRepository;

@Service
public class PostPageService {

	@Autowired
	private PostPageRepository postPageRepository;

	@Autowired
	private BbsRepository bbsRepository;

	@Transactional
	public void add(ContentEntity entity) {
		var bbsEntity = bbsRepository.findById(entity.getContentPk().getBbsId()).get();
		bbsEntity.getContents().add(entity);
	}

	@Transactional
	public void delete(int id, int no) {

		var bbsEntity = bbsRepository.findById(id).get();

		var pk = new ContentPk(id, no);
		var entity = postPageRepository.findById(pk).get();

		bbsEntity.getContents().remove(entity);
	}

	@Transactional
	public void update(ContentEntity entity) {
		postPageRepository.save(entity);
	}

}
