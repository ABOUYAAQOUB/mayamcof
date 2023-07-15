package com.mayamcof.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayamcof.IService.IProduit;
import com.mayamcof.model.Produit;

@CrossOrigin("*")
@RestController
@RequestMapping("/mayamcof")
public class ProduitControlleur {
	
	private IProduit produit;
	
	public ProduitControlleur(IProduit produit) {
		this.produit= produit;
	}
	
	@GetMapping("/produits")
	public List<Produit>getAll(){
		return this.produit.getAll();
	}
	
	@GetMapping("/produit/{id}")
	public Produit getProduit(@PathVariable long id) {
		return this.produit.getProduit(id);
	}
	
	@PostMapping("/produit")
	public Produit create(@RequestBody Produit produit) {
		return this.produit.create(produit);
	}
	
	@PutMapping("/produit")
	public Produit update(@RequestBody Produit produit) {
		return this.produit.create(produit);
	}
	
	@DeleteMapping("/produit/{id}")
	public void delete(@PathVariable Long id) {
		 this.produit.delete(id);
	}

}
