package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IConstruction;
import com.mayamcof.Repository.ConstructionRepository;
import com.mayamcof.model.Construction;

@Service
public class ConstructionService implements IConstruction{

	private ConstructionRepository constructionRepository;
	
	public ConstructionService(ConstructionRepository constructionRepository) {
		
		this.constructionRepository = constructionRepository;
	}

	@Override
	public List<Construction> getAll() {
		
		return this.constructionRepository.findAll();
	}

	@Override
	public Construction getConstruction(Long id) {
		
		return this.constructionRepository.findById(id).get();
	}

	@Override
	public Construction create(Construction construction) {
		
		return this.constructionRepository.save(construction);
	}

	@Override
	public Construction update(Construction construction) {
		
		Construction constructionUpdated = this.constructionRepository.findById(construction.getId()).get();
		
		constructionUpdated.setConfirmer(construction.isConfirmer());
		constructionUpdated.setConsommations(construction.getConsommations());
		constructionUpdated.setFacture(construction.getFacture());
		constructionUpdated.setPrix(construction.getPrix());
		constructionUpdated.setQuantite(construction.getQuantite());
		constructionUpdated.setTache(construction.getTache());
		constructionUpdated.setTerrain(construction.getTerrain());
		constructionUpdated.setUnite(construction.getUnite());
		
		return this.constructionRepository.save(constructionUpdated);
	}

	@Override
	public void delete(Long id) {
		
		this.constructionRepository.delete(this.constructionRepository.findById(id).get());
	}

	@Override
	public List<Construction> getAll(long id) {
		return this.constructionRepository.findByTerrain(id);
	}

}
