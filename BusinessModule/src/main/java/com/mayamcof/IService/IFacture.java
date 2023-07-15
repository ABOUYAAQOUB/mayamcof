package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Facture;

public interface IFacture {
	
	public List<Facture>getAll();
	public Facture getFacture(Long id);
	public Facture create(Facture facture);
	public Facture update(Facture facture);
	public void delete(Long id);

}
