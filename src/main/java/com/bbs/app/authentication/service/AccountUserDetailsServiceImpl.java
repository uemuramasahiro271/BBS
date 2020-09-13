package com.bbs.app.authentication.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.app.authentication.model.AccountUserDetails;
import com.bbs.app.entity.UserAccount;

@Service
public class AccountUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		UserAccount account = accountService.getAccount(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found");
		}

		return new AccountUserDetails(account, getAuthorities(account));
	}

	private Collection<GrantedAuthority> getAuthorities(UserAccount account){
		return AuthorityUtils.createAuthorityList(account.getRole());
	}
}
