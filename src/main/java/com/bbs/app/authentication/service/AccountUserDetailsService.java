package com.bbs.app.authentication.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface AccountUserDetailsService {

	UserDetails loadUserByUsername(String username);
}
