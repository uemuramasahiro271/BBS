//package com.bbs.app.authentication.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.bbs.app.authentication.entity.Account;
//import com.bbs.app.authentication.repository.AccountRepository;
//
//
//@Service
//public class AccountServiceImpl {
//
//	@Autowired
//	private AccountRepository accountRepository;
//
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Transactional(readOnly = true)
//	public Account getAccount(String userName) {
//		Account account = accountRepository.findOne(userName);
//		if(account == null) {
//			return null;
//		}
//		return account;
//	}
//
//	@Transactional(readOnly = true)
//	public List<Account> getAccountAll() {
//		return accountRepository.findAll(new  Sort(Direction.ASC, "userName"));
//	}
//
//	@Transactional
//	public Account createAccount(String userName, String password) {
//		Account account = new Account();
//		account.setUserName(userName);
//		account.setPassword(encode(password));
//		return accountRepository.save(account);
//	}
//
//	@Transactional
//	public Account updateAccountName(String userName, String password) {
//		Account account = getAccount(userName);
//		account.setPassword(encode(password));
//		return account;
//	}
//
//	@Transactional
//	public void deleteAccount(String userName) {
//		accountRepository.delete(userName);
//	}
//
//	private String encode(String password) {
//		return passwordEncoder.encode(password);
//	}
//}
