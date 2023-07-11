package com.mayamcof.Securite;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // ici je suis en train de lui dire que j'ai utilise le type de auth STATELESS
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/mayamcof/client/**","/mayamcof/clients/**").permitAll();
		//http.formLogin(); // donnee un page d'authontification
		http.authorizeRequests().anyRequest().permitAll();
		//http.authorizeRequests().antMatchers(HttpMethod.POST,"/mayamcof/client/**").permitAll();
		//http.authorizeRequests().anyRequest().authenticated();// c'est a dire touts les access il faut un authontification
//		http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean())); // voila le filter qui je doit utilise
//		http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
}
