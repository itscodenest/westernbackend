package com.tour.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.tour.service.AuditorAwareService;


@Configuration
@EnableResourceServer
@PropertySource("classpath:constants.properties")
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().antMatchers("/**").authenticated();

	}
	
	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareService();
	}

}