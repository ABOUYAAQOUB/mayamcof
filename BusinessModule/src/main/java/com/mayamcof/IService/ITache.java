package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Tache;

public interface ITache {
	
	public List<Tache>getAll();
	public Tache getTache(Long id);
	public Tache create(Tache tache);
	public Tache update(Tache tache);
	public void delete(Long id);

}
