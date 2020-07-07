package com.bbs.app.postpage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.app.postpage.entity.ContentEntity;
import com.bbs.app.postpage.entity.ContentPk;
import com.bbs.app.postpage.repository.PostPageRepository;

@Service
public class PostPageService {

	@Autowired
	private PostPageRepository postPageRepository;

	public void add(ContentEntity entity) {
		postPageRepository.saveAndFlush(entity);
	}

	public void delete(int id, int no) {
		postPageRepository.deleteById(new ContentPk(id, no));
	}

	public void update(ContentEntity entity) {
		postPageRepository.save(entity);
	}

}
