package com.mayamcof.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayamcof.IService.IUtilisateur;
import com.mayamcof.exception.AuthenticationException;
import com.mayamcof.model.Utilisateur;


@RestController
@RequestMapping("/mayamcof")
public class UtilisateurController {

	private IUtilisateur iUtilisateur;

	public UtilisateurController(IUtilisateur iUtilisateur,AuthenticationManager authenticationManager) {
		
		this.iUtilisateur = iUtilisateur;
	}
	
	@GetMapping("/utilisateurs")
	public List<Utilisateur>getAll(){
		
		return this.iUtilisateur.getAll();
	}
	
	@PostMapping("/utilisateur")
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		
		return this.iUtilisateur.create(utilisateur);
	}
	
	@PutMapping("/utilisateur")
	public Utilisateur update(@RequestBody Utilisateur utilisateur) {
		
		return this.iUtilisateur.update(utilisateur);
	}
	
	@DeleteMapping("/utilisateur/{id}")
	public void delete (@PathVariable long id) {
		
		this.iUtilisateur.deleteUtilisateur(id);
	}
	
	@GetMapping("/refreshToken")
	public void getRefreshToken(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("!! getRefreshToken !!");
		String authToken = request.getHeader("Authorization");
		if(authToken != null && authToken.startsWith("Bearer ")) {
			try {
				
				String jwt = authToken.substring(7);
				Algorithm algorithm = Algorithm.HMAC256("SPRING_SECURITY_API");
				JWTVerifier jwtVerifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
				String username = decodedJWT.getSubject();
				Utilisateur utilisateur = this.iUtilisateur.loadUserByUsername(username);
				
				ArrayList<String>roles = new ArrayList<String>();
				
				if(utilisateur.isRole()) roles.add("admin");else roles.add("admin");
					
				
				String jwtAccessToken = JWT.create()
						.withSubject(utilisateur.getNom())
						.withExpiresAt(new Date(System.currentTimeMillis()+1*60*1000))
						.withIssuer(request.getRequestURI().toString())
						.withClaim("roles", roles.stream().map(rs->rs).collect(Collectors.toList()))
						.sign(algorithm);
				
				Map<String, String> idToken = new HashMap<>();
				idToken.put("access-token", jwtAccessToken);
				idToken.put("refresh-token", jwt);
				
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), idToken);
				
			} catch (Exception e) {				
					
				throw new AuthenticationException("Refresh Token est expiré ou incorrecte", "0000", "refreshToken");
				// refresh token est non corecte ou experier
			}
		}else {
			throw new AuthenticationException("!! Refresh token Required !!", "0000", "refreshToken");
		}
		
	}
}
