package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Utilisateur;

public interface IUtilisateur {

	public List<Utilisateur>getAll();
	public Utilisateur create(Utilisateur utilisateur);
	public Utilisateur update(Utilisateur utilisateur);
	public Utilisateur loadUserByUsername(String username);
	public void deleteUtilisateur(long id);
}
