package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Fournisseur;

public interface IFournisseur {
	
	public List<Fournisseur>getAll();
	public Fournisseur getFournisseur(Long id);
	public Fournisseur create(Fournisseur fournisseur);
	public Fournisseur update(Fournisseur fournisseur);
	public void delete(Long id);

}
