package com.bbs.app.authentication.service;

import java.util.List;

import com.bbs.app.entity.UserAccount;

public interface AccountService {

	UserAccount getAccount(String userName);
	List<UserAccount> getAccountAll();
	UserAccount createAccount(String userName, String password, String role);
	UserAccount updateAccountName(String userName, String password);
	void deleteAccount(String userName);
}
