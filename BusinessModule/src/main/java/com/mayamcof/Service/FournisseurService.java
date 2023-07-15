package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IFournisseur;
import com.mayamcof.Repository.FournisseurRepository;
import com.mayamcof.exception.UniqueException;
import com.mayamcof.model.Fournisseur;

@Service
public class FournisseurService implements IFournisseur {

	private FournisseurRepository fournisseurRepository;
	
	public FournisseurService(FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository=fournisseurRepository;
	}
	
	@Override
	public List<Fournisseur> getAll() {
		return this.fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur getFournisseur(Long id) {
		return this.fournisseurRepository.findById(id).orElse(null);
	}

	@Override
	public Fournisseur create(Fournisseur fournisseur) {
		
		if(this.fournisseurRepository.getByICE(fournisseur.getICE()) == null) {
			
			return this.fournisseurRepository.save(fournisseur);
			
		}else {
			
			throw new UniqueException("Fournisseur deja existe","0000","ICE");
		}
		
	}

	@Override
	public Fournisseur update(Fournisseur fournisseur) {
		
		if(this.fournisseurRepository.getByICE(fournisseur.getICE()) == null || this.fournisseurRepository.getByICE(fournisseur.getICE()).getId() == fournisseur.getId()) {
			
			return this.fournisseurRepository.save(fournisseur);
		}else {
			
			throw new UniqueException("Fournisseur deja existe","0000","ICE");
		}
		
	}

	@Override
	public void delete(Long id) {
		this.fournisseurRepository.deleteById(id);
	}

}
