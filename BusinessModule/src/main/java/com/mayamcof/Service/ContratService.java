package com.mayamcof.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IContrat;
import com.mayamcof.Repository.ContratRepository;
import com.mayamcof.Repository.TerrainRepository;
import com.mayamcof.model.Contrat;
import com.mayamcof.model.Terrain;

@Service
public class ContratService implements IContrat{
	
	private ContratRepository contratRepository;
	private TerrainRepository terrainRepository;

	public ContratService(ContratRepository contratRepository,TerrainRepository terrainRepository) {
		
		this.contratRepository = contratRepository;
		this.terrainRepository = terrainRepository;
	}
	
	@Override
	public Contrat getContratByTerrainId(long id) {
		
		return this.terrainRepository.findById(id).orElse(null).getContrat();
	}

	@Override
	public List<Contrat> getAll() {
		
		return this.contratRepository.findAll();
	}

	@Override
	public Contrat getContrat(Long id) {
		
		return this.contratRepository.findById(id).get();
	}

	@Override
	public Contrat create(Contrat contrat) {
		Terrain t = terrainRepository.findById(contrat.getTerrain().getId()).get();
		contrat.setTerrain(t);		
		return this.contratRepository.save(contrat);
	}

	@Override
	public Contrat update(Contrat contrat) {
		Terrain t = terrainRepository.findById(contrat.getTerrain().getId()).get();
		t.setContrat(contrat);
		contrat.setTerrain(t);
		return this.contratRepository.save(contrat);
	}

	@Override
	public void delete(Long id) {
		
		this.contratRepository.delete(this.contratRepository.findById(id).get());
	}

}
