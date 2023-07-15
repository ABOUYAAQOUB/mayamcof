package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Terrain;

public interface ITerrain {
	
	public List<Terrain>getAll();
	public Terrain getTerrain(Long id);
	public Terrain create(Terrain terrain);
	public Terrain update(Terrain terrain);
	public void delete(Long id);
}
