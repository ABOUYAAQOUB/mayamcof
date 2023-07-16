package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mayamcof.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	
	Utilisateur findByUsername(String username);
}
