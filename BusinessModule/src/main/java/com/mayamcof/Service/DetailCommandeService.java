package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IDetailCommande;
import com.mayamcof.Repository.DetailCommandeRepository;
import com.mayamcof.model.DetailCommande;

@Service
public class DetailCommandeService implements IDetailCommande{

	private DetailCommandeRepository detailCommandeRepository;
	
	public DetailCommandeService(DetailCommandeRepository detailCommandeRepository) {
		
		this.detailCommandeRepository = detailCommandeRepository;
	}

	@Override
	public List<DetailCommande> getAll() {
		
		return this.detailCommandeRepository.findAll();
	}

	@Override
	public DetailCommande getDetailCommande(Long id) {
		
		return this.detailCommandeRepository.findById(id).get();
	}

	@Override
	public DetailCommande create(DetailCommande detailCommande) {
		
		return this.detailCommandeRepository.save(detailCommande);
	}

	@Override
	public DetailCommande update(DetailCommande detailCommande) {
		
		DetailCommande detailCommandeUpdated = this.detailCommandeRepository.findById(detailCommande.getId()).get();
		
		detailCommandeUpdated.setPrix(detailCommande.getPrix());
		detailCommandeUpdated.setQuantite(detailCommande.getQuantite());
		detailCommandeUpdated.setProduit(detailCommande.getProduit());
		detailCommandeUpdated.setCommande(detailCommande.getCommande());
		
		return this.detailCommandeRepository.save(detailCommandeUpdated);
	}

	@Override
	public void delete(Long id) {
		
		this.detailCommandeRepository.delete(this.detailCommandeRepository.findById(id).get());
	}

	@Override
	public List<DetailCommande> getDetailByCommande(long id) {
		
		return this.detailCommandeRepository.getDetailByCommande(id);
	}

}
