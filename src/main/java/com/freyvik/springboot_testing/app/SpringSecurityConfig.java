package com.freyvik.springboot_testing.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService users() {
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(password -> {
			return encoder.encode(password);
		});
		UserDetails user = users
			.username("user")
			.password("123")
			.roles("USER")
			.build();
		UserDetails admin = users
			.username("admin")
			.password("1234")
			.roles("USER", "ADMIN")
			.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

}
