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

import com.mayamcof.IService.ICommande;
import com.mayamcof.model.Commande;

@CrossOrigin("*")
@RestController
@RequestMapping("/mayamcof")
public class CommandeController {

	private ICommande iCommande;

	public CommandeController(ICommande iCommande) {
		
		this.iCommande = iCommande;
	}
	
	@GetMapping("/commandes")
	public List<Commande>getAll(){
		
		return this.iCommande.getAll();
	}
	
	@GetMapping("/commande/{id}")
	public Commande getCommande(@PathVariable long id) {
		
		return this.iCommande.getCommande(id);
	}
	
	@PostMapping("/commande")
	public Commande create(@RequestBody Commande commande) {
		
		return this.iCommande.create(commande);
	}
	
	@PutMapping("/commande")
	public Commande update(@RequestBody Commande commande) {
		
		return this.iCommande.update(commande);
	}
	
	@DeleteMapping("/commande/{id}")
	public void delete(@PathVariable long id) {
		
		this.iCommande.delete(id);
	}
	
}
