package com.bbs.app.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("auth/loginForm");

		return mv;
	}

	@GetMapping("/logout")
	public ModelAndView logout(ModelAndView mv) {
		mv.setViewName("auth/logoutForm");

		return mv;
	}
}
