package com.ionix.ionix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${security.user}")
	private String usuario;
	
	@Value("${security.pass}")
	private String pass;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.httpBasic(withDefaults())
    	.authorizeRequests()
    	.antMatchers("/publico/**").permitAll()
    	.antMatchers("/admin/**").hasRole("ADMIN");
  }
  
  public void configure(AuthenticationManagerBuilder auth) throws Exception{
	  auth.inMemoryAuthentication()
	  	  .withUser(usuario).password("{noop}" + pass).roles("ADMIN");
  }
}
