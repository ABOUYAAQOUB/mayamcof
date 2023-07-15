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

import com.mayamcof.IService.IFacture;
import com.mayamcof.model.Facture;

@CrossOrigin("*")
@RestController
@RequestMapping("/mayamcof")
public class FactureController {
	
	private IFacture facture;
	
	public FactureController(IFacture facture) {
		this.facture=facture;
	}
	
	@GetMapping("/factures")
	public List<Facture>getAll(){
		return this.facture.getAll();
	}
	
	@GetMapping("/facture/{id}")
	public Facture getFacture(@PathVariable long id) {
		return this.facture.getFacture(id);
	}
	
	@PostMapping("/facture")
	public Facture create(@RequestBody Facture facture) {
		return this.facture.create(facture);
	}
	
	@PutMapping("/facture")
	public Facture update(@RequestBody Facture facture) {
		return this.facture.update(facture);
	}
	
	@DeleteMapping("/facture/{id}")
	public void delete(@PathVariable Long id) {
		this.facture.delete(id);
	}

}
