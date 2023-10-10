package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Travailler;

public interface ITravailler {
	
	public List<Travailler>getAll();
	public Travailler getTravailler(Long id);
	public Travailler create(Travailler Travailler);
	public Travailler update(Travailler Travailler);
	public void delete(Long id);
	public List<Travailler> getByConstruction(Long id);
}
