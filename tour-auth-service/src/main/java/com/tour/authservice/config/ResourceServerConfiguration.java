package com.tour.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.tour.authservice.service.impl.CustomOAuth2UserService;

@Configuration
@EnableResourceServer
@Order(-20)
public class ResourceServerConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService customerUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/login/**","/oauth2/**").and().authorizeRequests().anyRequest().permitAll()
		.and()
        .oauth2Login()
            .loginPage("/login")
            .userInfoEndpoint()
                .userService(oauthUserService);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.parentAuthenticationManager(authenticationManager).userDetailsService(customerUserDetailsService);
	}
	/*
	 * private static final String RESOURCE_ID = "tour";
	 * 
	 * @Override public void configure(ResourceServerSecurityConfigurer resources)
	 * throws Exception { resources.resourceId(RESOURCE_ID); }
	 * 
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeRequests().anyRequest().authenticated(); }
	 */

	@Autowired
	private CustomOAuth2UserService oauthUserService;
}