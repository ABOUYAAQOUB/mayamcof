package com.mayamcof.Securite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("!! doFilterInternal !!");
		if(request.getServletPath().equals("/mayamcof/refreshToken")) {
			
			filterChain.doFilter(request, response);
			
		}else {
			
			String authorizationTkon = request.getHeader("Authorization");
			
			if(authorizationTkon != null && authorizationTkon.startsWith("Bearer ")) {
				
				try {
					
					String jwt = authorizationTkon.substring(7);
					Algorithm algorithm = Algorithm.HMAC256("SPRING_SECURITY_API");
					JWTVerifier jwtVerifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
					String username = decodedJWT.getSubject();
					String[]roles = decodedJWT.getClaim("roles").asArray(String.class);
					
					Collection<GrantedAuthority>authorities = new ArrayList<GrantedAuthority>();
					for(String r:roles) {
						authorities.add(new SimpleGrantedAuthority(r));
					}
					
					UsernamePasswordAuthenticationToken 
					authenticationToken = new UsernamePasswordAuthenticationToken(username, null,authorities);
					
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					filterChain.doFilter(request, response);
				
				} catch (Exception e) {
					
					response.setHeader("error-message-security",e.getMessage());
					response.sendError(HttpServletResponse.SC_FORBIDDEN);
					// le acccess token est experi // ou refresh token
				}
			}else {
				filterChain.doFilter(request, response);
			}
			
		}
		
	}
	
	

}
