package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IFacture;
import com.mayamcof.Repository.FactureRepository;
import com.mayamcof.model.Facture;

@Service
public class FactureService implements IFacture {

	private FactureRepository factureRepository;
	
	public FactureService(FactureRepository factureRepository) {
		this.factureRepository=factureRepository;
	}
	
	@Override
	public List<Facture> getAll() {
		return this.factureRepository.findAll();
	}

	@Override
	public Facture getFacture(Long id) {
		return this.factureRepository.findById(id).orElse(null);
	}

	@Override
	public Facture create(Facture facture) {
		return this.factureRepository.save(facture);
	}

	@Override
	public Facture update(Facture facture) {
	 return this.factureRepository.save(facture);
	}

	@Override
	public void delete(Long id) {
		this.factureRepository.deleteById(id);
	}

}
