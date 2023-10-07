package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.DetailCommande;

public interface IDetailCommande {

	public List<DetailCommande>getAll();
	public List<DetailCommande>getDetailByCommande(long id);
	public DetailCommande getDetailCommande(Long id);
	public DetailCommande create(DetailCommande detailCommande);
	public DetailCommande update(DetailCommande detailCommande);
	public void delete(Long id);
	
}
