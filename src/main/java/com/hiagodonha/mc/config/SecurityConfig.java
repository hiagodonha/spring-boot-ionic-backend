package com.hiagodonha.mc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hiagodonha.mc.bo.UserDetailsBo;
import com.hiagodonha.mc.security.JWTAuthenticationFilter;
import com.hiagodonha.mc.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsBo userDetailsBo;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	private static final String PUBLIC_MATCHERS_GET [] = {
			"/produtos/**",
			"/categorias/**",
			"/clientes/**",
			"/login/**"
	};
	
	private static final String PUBLIC_MATCHERS_POST [] = {
		"/clientes/**"
	};
	
	@Override
	protected void configure (HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
	}
	
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsBo).passwordEncoder(encoder());
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
