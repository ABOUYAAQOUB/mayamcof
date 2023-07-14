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

import com.mayamcof.IService.IFournisseur;
import com.mayamcof.model.Fournisseur;

@CrossOrigin("*")
@RestController
@RequestMapping("/mayamcof")
public class FournisseurController {
	
	private IFournisseur fournisseur;
	
	public FournisseurController(IFournisseur fournisseur) {
		this.fournisseur=fournisseur;
	}
	
	@GetMapping("/fournisseurs")
	public List<Fournisseur>getAll(){
		return this.fournisseur.getAll();
	}
	
	@GetMapping("/fournisseur/{id}")
	public Fournisseur getFournisseur(@PathVariable long id) {
		return this.fournisseur.getFournisseur(id);
	}
	
	@PostMapping("/fournisseur")
	public Fournisseur create(@RequestBody Fournisseur fournisseur) {
		return this.fournisseur.create(fournisseur);
	}
	
	@PutMapping("/fournisseur")
	public Fournisseur update(@RequestBody Fournisseur fournisseur) {
		return this.fournisseur.update(fournisseur);
	}
	
	@DeleteMapping("/fournisseur/{id}")
	public void delete(@PathVariable Long id) {
		this.fournisseur.delete(id);
	}

}
