package com.bbs.app.selection_bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbs.app.selection_bbs.entity.BbsEntity;

@Repository
public interface BbsRepository extends JpaRepository<BbsEntity, Integer> {

}
