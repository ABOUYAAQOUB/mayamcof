package com.mayamcof.Securite;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayamcof.exception.UniqueException;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	private final ObjectMapper objectMapper;

   	public JwtAuthenticationFilter(AuthenticationManager authenticationManager,ObjectMapper objectMapper) {
		
		this.authenticationManager = authenticationManager;
		   this.objectMapper = objectMapper;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {		
		try {
			System.out.println("!! attemptAuthentication !!");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			
			return this.authenticationManager.authenticate(authenticationToken);
		} catch (Exception e) {
			 response.setStatus(HttpStatus.UNAUTHORIZED.value());
	         response.setContentType("application/json");

	            Map<String, Object> errorResponse = new HashMap<>();
	            errorResponse.put("status", HttpStatus.UNAUTHORIZED.value());
	            errorResponse.put("message", "Username or password incorrect");
	            errorResponse.put("error", e.getMessage());

	            String jsonResponse = null;
				try {
					jsonResponse = objectMapper.writeValueAsString(errorResponse);
					response.getWriter().write(jsonResponse);
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		return null;
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		System.out.println("!! successfulAuthentication !!");
		User user = (User) authResult.getPrincipal();
		
		Algorithm algorithm = Algorithm.HMAC256("SPRING_SECURITY_API");
		
		String jwtAccessToken = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+15*60*1000))
				.withIssuer(request.getRequestURI().toString())
				.withClaim("roles", user.getAuthorities().stream().map(rs->rs.getAuthority()).collect(Collectors.toList()))
				.sign(algorithm);
		
		String jwtRefreshToken = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+15*60*1000))
				.withIssuer(request.getRequestURI().toString())
				.sign(algorithm);
		
		Map<String, String> idToken = new HashMap<>();
		idToken.put("access-token", jwtAccessToken);
		idToken.put("refresh-token", jwtRefreshToken);
		
		response.setContentType("application/json");
		new ObjectMapper().writeValue(response.getOutputStream(), idToken);
		
	}
}
