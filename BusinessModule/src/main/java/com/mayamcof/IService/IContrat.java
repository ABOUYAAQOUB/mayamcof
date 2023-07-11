package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Contrat;

public interface IContrat {

	public List<Contrat>getAll();
	public Contrat getContrat(Long id);
	public Contrat create(Contrat contrat);
	public Contrat update(Contrat contrat);
	public void delete(Long id);
}
