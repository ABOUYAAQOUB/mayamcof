package com.mayamcof.Securite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.MissingClaimException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayamcof.exception.AuthenticationException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{
	
	
	private final ObjectMapper objectMapper;

    public JwtAuthorizationFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws AuthenticationException,ServletException, IOException{
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
				
				}catch (TokenExpiredException e) {
					response.setStatus(HttpStatus.UNAUTHORIZED.value());
			         response.setContentType("application/json");

			            Map<String, Object> errorResponse = new HashMap<>();
			            errorResponse.put("status", HttpStatus.UNAUTHORIZED.value());
			            errorResponse.put("message", "Token Expired");
			            errorResponse.put("error", e.getMessage());

			            String jsonResponse = objectMapper.writeValueAsString(errorResponse);
			            response.getWriter().write(jsonResponse);
				}catch (Exception  e) {
					
					 response.setStatus(HttpStatus.UNAUTHORIZED.value());
			         response.setContentType("application/json");

			            Map<String, Object> errorResponse = new HashMap<>();
			            errorResponse.put("status", HttpStatus.UNAUTHORIZED.value());
			            errorResponse.put("message", "Token inccorecte");
			            errorResponse.put("error", e.getMessage());

			            String jsonResponse = objectMapper.writeValueAsString(errorResponse);
			            response.getWriter().write(jsonResponse);
				}
				
			}else {
				filterChain.doFilter(request, response);
			}
			
		}
		
	}
	
	

}
