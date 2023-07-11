package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IContrat;
import com.mayamcof.Repository.ContratRepository;
import com.mayamcof.model.Contrat;

@Service
public class ContratService implements IContrat{
	
	private ContratRepository contratRepository;

	public ContratService(ContratRepository contratRepository) {
		
		this.contratRepository = contratRepository;
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
		
		return this.contratRepository.save(contrat);
	}

	@Override
	public Contrat update(Contrat contrat) {
		
		Contrat contratUpdated = this.contratRepository.findById(contrat.getId()).get();
		
		contratUpdated.setContratpdf(contrat.getContratpdf());
		contratUpdated.setDatecontrat(contrat.getDatecontrat());
		contratUpdated.setTerrain(contrat.getTerrain());
		
		return this.contratRepository.save(contratUpdated);
	}

	@Override
	public void delete(Long id) {
		
		this.contratRepository.delete(this.contratRepository.findById(id).get());
	}

}
