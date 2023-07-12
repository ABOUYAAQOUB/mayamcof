package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Commande;

public interface ICommande {

	public List<Commande>getAll();
	public Commande getCommande(Long id);
	public Commande create(Commande commande);
	public Commande update(Commande commande);
	public void delete(Long id);
}
