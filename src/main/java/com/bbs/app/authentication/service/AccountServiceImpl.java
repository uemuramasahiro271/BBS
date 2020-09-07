package com.bbs.app.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.app.entity.UserAccount;
import com.bbs.app.entity.UserAccountExample;
import com.bbs.app.mapper.UserAccountMapper;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserAccountMapper userAccountMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	@Transactional(readOnly = true)
	public UserAccount getAccount(String userName) {
		return userAccountMapper.selectByPrimaryKey(userName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserAccount> getAccountAll() {

		UserAccountExample example = new UserAccountExample();
		example.setOrderByClause("name ASC");

		return userAccountMapper.selectByExample(example);
	}

	@Override
	@Transactional
	public UserAccount createAccount(String userName, String password, String role) {
		UserAccount account = new UserAccount();
		account.setName(userName);
		account.setPassword(encode(password));
		account.setRole(role);

		userAccountMapper.insert(account);
		return account;
	}

	@Override
	@Transactional
	public UserAccount updateAccountName(String userName, String password) {
		UserAccount account = getAccount(userName);
		account.setPassword(encode(password));

		userAccountMapper.updateByPrimaryKey(account);

		return account;
	}

	@Override
	@Transactional
	public void deleteAccount(String userName) {
		userAccountMapper.deleteByPrimaryKey(userName);
	}

	private String encode(String password) {
		return passwordEncoder.encode(password);
	}
}
