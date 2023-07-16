package com.mayamcof.Service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mayamcof.IService.IUtilisateur;
import com.mayamcof.Repository.UtilisateurRepository;
import com.mayamcof.model.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateur{

	private UtilisateurRepository utilisateurRepository;
	private PasswordEncoder passwordEncoder;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository,PasswordEncoder passwordEncoder) {
		
		this.utilisateurRepository = utilisateurRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<Utilisateur> getAll() {
		
		return this.utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur create(Utilisateur utilisateur) {
		
		utilisateur.setPassword(this.passwordEncoder.encode(utilisateur.getPassword()));
		
		return this.utilisateurRepository.save(utilisateur);
	}

	@Override
	public Utilisateur loadUserByUsername(String username) {
		
		
		return this.utilisateurRepository.findByUsername(username);
	}

}
