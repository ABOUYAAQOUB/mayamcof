package com.mayamcof.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayamcof.IService.IDetailCommande;
import com.mayamcof.model.DetailCommande;


@RestController
@RequestMapping("/mayamcof")
public class DetailCommandeController {

	private IDetailCommande iDetailCommande;

	public DetailCommandeController(IDetailCommande iDetailCommande) {
		
		this.iDetailCommande = iDetailCommande;
	}
	
	@GetMapping("/detailCommandes")
	public List<DetailCommande>getAll(){
		
		return this.iDetailCommande.getAll();
	}
	
	@GetMapping("/detailCommandes/{id}")
	public List<DetailCommande>getDetailByCommande(@PathVariable long id){
		
		return this.iDetailCommande.getDetailByCommande(id);
	}
	
	@GetMapping("/detailCommande/{id}")
	public DetailCommande getCommande(@PathVariable long id) {
		
		return this.iDetailCommande.getDetailCommande(id);
	}
	
	@PostMapping("/detailCommande")
	public DetailCommande create(@RequestBody DetailCommande detailCommande) {
		
		return this.iDetailCommande.create(detailCommande);
	}
	
	@PutMapping("/detailCommande")
	public DetailCommande update(@RequestBody DetailCommande detailCommande) {
		
		return this.iDetailCommande.update(detailCommande);
	}
	
	@DeleteMapping("/detailCommande/{id}")
	public void delete(@PathVariable long id) {
		
		this.iDetailCommande.delete(id);
	}
	
}
