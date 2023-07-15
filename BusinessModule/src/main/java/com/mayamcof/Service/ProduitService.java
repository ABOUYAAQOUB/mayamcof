package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IProduit;
import com.mayamcof.Repository.ProduitRepository;
import com.mayamcof.model.Produit;

@Service
public class ProduitService implements IProduit{

	private ProduitRepository produitRepository;
	
	public ProduitService(ProduitRepository produitRepository) {
		this.produitRepository=produitRepository;
	}
	
	@Override
	public List<Produit> getAll() {
		return this.produitRepository.findAll();
	}

	@Override
	public Produit getProduit(Long id) {
		return this.produitRepository.findById(id).orElse(null);
	}

	@Override
	public Produit create(Produit produit) {
		return this.produitRepository.save(produit);
	}

	@Override
	public Produit update(Produit produit) {
          return this.produitRepository.save(produit);
	}

	@Override
	public void delete(Long id) {
		 this.produitRepository.deleteById(id);
	}

}
