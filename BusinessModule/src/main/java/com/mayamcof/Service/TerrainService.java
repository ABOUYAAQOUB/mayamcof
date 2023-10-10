package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.ITerrain;
import com.mayamcof.Repository.TerrainRepository;
import com.mayamcof.model.Terrain;

@Service
public class TerrainService implements ITerrain{

	private TerrainRepository terrainRepository;
	
	public TerrainService(TerrainRepository terrainRepository) {
		
		this.terrainRepository = terrainRepository;
	}

	@Override
	public List<Terrain> getAll() {
		
		return this.terrainRepository.findAll();
	}

	@Override
	public Terrain getTerrain(Long id) {
		
		return this.terrainRepository.findById(id).get();
	}

	@Override
	public Terrain create(Terrain terrain) {
		
		return this.terrainRepository.save(terrain);
	}

	@Override
	public Terrain update(Terrain terrain) {
		
		Terrain terrainUpdated = this.terrainRepository.findById(terrain.getId()).get();
		
		terrainUpdated.setAdresse(terrain.getAdresse());
		terrainUpdated.setClient(terrain.getClient());
		terrainUpdated.setConstructions(terrain.getConstructions());
		terrainUpdated.setContrat(terrain.getContrat());
		terrainUpdated.setEtage(terrain.getEtage());
		terrainUpdated.setSurface(terrain.getSurface());
		
		return this.terrainRepository.save(terrainUpdated);
	}

	@Override
	public void delete(Long id) {
		
		this.terrainRepository.delete(this.terrainRepository.findById(id).get());
	}

	@Override
	public List<Terrain> getTerrainNotContrat() {
		
		return this.terrainRepository.getTerrainNotContrat();
	}

	@Override
	public List<Terrain> getTerrainUpdate(long id) {
		
		return this.terrainRepository.getTerrainUpdate(id);
	}

}
