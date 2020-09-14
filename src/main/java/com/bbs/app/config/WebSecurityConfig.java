package com.bbs.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/static/**"
    };

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/")
		.permitAll();

		http.authorizeRequests()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.antMatchers("/login").permitAll()
	        .antMatchers("/accountRegister").permitAll()
	        .antMatchers(HttpMethod.POST, "/register").permitAll()
	        .antMatchers("/result").permitAll()
			.anyRequest().authenticated();

		http.logout()
			.logoutSuccessUrl("/logout")
			.permitAll();
	}
}
