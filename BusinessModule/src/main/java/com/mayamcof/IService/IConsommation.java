package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Consommation;

public interface IConsommation {

	public List<Consommation>getAll();
	public List<Consommation>getAll(long id);
	public Consommation getConsommation(Long id);
	public Consommation create(Consommation consommation);
	public Consommation update(Consommation consommation);
	public void delete(Long id);
}
