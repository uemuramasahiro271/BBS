package com.bbs.app.postpage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.app.postpage.entity.ContentEntity;
import com.bbs.app.postpage.entity.ContentPk;
import com.bbs.app.postpage.repository.PostPageRepository;

@Service
public class PostPageService {

	@Autowired
	private PostPageRepository postPageRepository;

	@Transactional
	public void add(ContentEntity entity) {
		postPageRepository.saveAndFlush(entity);
	}

	@Transactional
	public void delete(int id, int no) {
		var pk = new ContentPk(id, no);
		var entity = postPageRepository.findById(pk).get();
		postPageRepository.delete(entity);
		//postPageRepository.deleteById(new ContentPk(id, no));
	}

	@Transactional
	public void update(ContentEntity entity) {
		postPageRepository.save(entity);
	}

}
