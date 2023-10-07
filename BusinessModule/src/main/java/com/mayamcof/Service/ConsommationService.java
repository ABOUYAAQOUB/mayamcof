package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IConsommation;
import com.mayamcof.Repository.ConsommationRepository;
import com.mayamcof.model.Consommation;

@Service
public class ConsommationService implements IConsommation{

	private ConsommationRepository consommationRepository;
	
	public ConsommationService(ConsommationRepository consommationRepository) {
		
		this.consommationRepository = consommationRepository;
	}

	@Override
	public List<Consommation> getAll() {
		
		return this.consommationRepository.findAll();
	}
	
	@Override
	public List<Consommation> getAll(long id) {
		
		return this.consommationRepository.findByConstruction(id);
	}

	@Override
	public Consommation getConsommation(Long id) {
		
		return this.consommationRepository.findById(id).get();
	}

	@Override
	public Consommation create(Consommation consommation) {
		
		return this.consommationRepository.save(consommation);
	}

	@Override
	public Consommation update(Consommation consommation) {
		
		Consommation consommationUpdated = this.consommationRepository.findById(consommation.getId()).get();
		
		consommationUpdated.setConstruction(consommation.getConstruction());
		consommationUpdated.setProduit(consommation.getProduit());
		consommationUpdated.setQuantite(consommation.getQuantite());
		
		return this.consommationRepository.save(consommationUpdated);
	}

	@Override
	public void delete(Long id) {
		
		this.consommationRepository.delete(this.consommationRepository.findById(id).get());
	}

}
