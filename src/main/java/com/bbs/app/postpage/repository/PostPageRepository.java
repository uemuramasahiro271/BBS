package com.bbs.app.postpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbs.app.postpage.entity.ContentEntity;
import com.bbs.app.postpage.entity.ContentPk;

@Repository
public interface PostPageRepository extends JpaRepository<ContentEntity, ContentPk>{

}
