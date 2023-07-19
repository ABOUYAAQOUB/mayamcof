package com.mayamcof.Service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mayamcof.IService.IUtilisateur;
import com.mayamcof.Repository.UtilisateurRepository;
import com.mayamcof.exception.UniqueException;
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
		
		if(this.utilisateurRepository.findByUsername(utilisateur.getUsername()) == null) {
			
			utilisateur.setPassword(this.passwordEncoder.encode(utilisateur.getPassword()));
		
			return this.utilisateurRepository.save(utilisateur);
		}else {
			throw new UniqueException("Utilisateur existe deja", "0000","Username");
		}
		
	}

	@Override
	public Utilisateur loadUserByUsername(String username) {
		
		
		return this.utilisateurRepository.findByUsername(username);
	}

	@Override
	public void deleteUtilisateur(long id) {
		
		this.utilisateurRepository.delete(this.utilisateurRepository.findById(id).get());
	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		
		if(this.utilisateurRepository.findByUsername(utilisateur.getUsername()) == null || this.utilisateurRepository.findByUsername(utilisateur.getUsername()).getId() == utilisateur.getId()) {
			
			Utilisateur utilisateur2 = this.utilisateurRepository.findById(utilisateur.getId()).get();
			
			if(utilisateur.getPassword().isEmpty())
			{
				utilisateur.setPassword(utilisateur2.getPassword());
			}else {
				
				utilisateur.setPassword(this.passwordEncoder.encode(utilisateur.getPassword()));
			}
			
			return this.utilisateurRepository.save(utilisateur);
			
		}else {
			
			throw new UniqueException("Utilisateur existe deja", "0000","Username");
		}
	}

}
