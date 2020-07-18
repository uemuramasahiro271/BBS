package com.bbs.app.selection_bbs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bbs.app.selection_bbs.entity.BbsEntity;

@Repository
public interface BbsRepository extends JpaRepository<BbsEntity, Integer> {

	@Query("SELECT b FROM BbsEntity b WHERE b.title LIKE %:titleCondition%")
	List<BbsEntity> findBbs(@Param("titleCondition") String titleCondition);

}
