package com.bbs.app.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bbs.app.authentication.entity.AccountEntity;


@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Integer>{

}
