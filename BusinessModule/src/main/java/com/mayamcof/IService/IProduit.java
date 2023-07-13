package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Produit;

public interface IProduit {
	
	public List<Produit>getAll();
	public Produit getProduit(Long id);
	public Produit create(Produit produit);
	public Produit update(Produit produit);
	public void delete(Long id);

}
