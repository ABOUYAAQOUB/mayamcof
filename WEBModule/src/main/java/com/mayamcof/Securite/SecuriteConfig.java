package com.mayamcof.Securite;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayamcof.IService.IUtilisateur;
import com.mayamcof.model.Utilisateur;

@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter{
	
	private IUtilisateur iUtilisateur;

	public SecuriteConfig(IUtilisateur iUtilisateur) {
	
		this.iUtilisateur = iUtilisateur;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
				Utilisateur utilisateur = iUtilisateur.loadUserByUsername(username);
				Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				
				if(utilisateur.isRole()) {
					authorities.add(new SimpleGrantedAuthority("admin"));
				}else {
					authorities.add(new SimpleGrantedAuthority("user"));
				}
				return new User(utilisateur.getUsername(),utilisateur.getPassword(),authorities);
			}
		});
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .cors();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // ici je suis en train de lui dire que j'ai utilise le type de auth STATELESS
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/mayamcof/refreshToken","/mayamcof/login").permitAll();
		//http.formLogin(); // donnee un page d'authontification
		//http.authorizeRequests().anyRequest().permitAll();
		//http.authorizeRequests().antMatchers(HttpMethod.POST,"/mayamcof/client/**").permitAll();
		http.authorizeRequests().anyRequest().authenticated();// c'est a dire touts les access il faut un authontification
		http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean(),objectMapper())); // voila le filter qui je doit utilise
		http.addFilterBefore(new JwtAuthorizationFilter(objectMapper()), UsernamePasswordAuthenticationFilter.class);
		http.addFilter(this.getAuthenticationFilter());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	
	protected JwtAuthenticationFilter getAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter(authenticationManagerBean(),objectMapper());
        filter.setFilterProcessesUrl("/mayamcof/login");
        return filter;
    }
	
	@Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
	  
	
}
