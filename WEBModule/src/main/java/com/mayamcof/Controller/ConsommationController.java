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

import com.mayamcof.IService.IConsommation;
import com.mayamcof.model.Consommation;

@CrossOrigin("*")
@RestController
@RequestMapping("/mayamcof")
public class ConsommationController {

	private IConsommation iConsommation;

	public ConsommationController(IConsommation iConsommation) {
		
		this.iConsommation = iConsommation;
	}
	
	@GetMapping("/consommations")
	public List<Consommation>getAll(){
		
		return this.iConsommation.getAll();
	}
	
	@GetMapping("/consommation/{id}")
	public Consommation getConsommation(@PathVariable long id) {
		
		return this.iConsommation.getConsommation(id);
	}
	
	@PostMapping("/consommation")
	public Consommation create(@RequestBody Consommation consommation) {
		
		return this.iConsommation.create(consommation);
	}
	
	@PutMapping("/consommation")
	public Consommation update(@RequestBody Consommation consommation) {
		
		return this.iConsommation.update(consommation);
	}
	
	@DeleteMapping("/consommation/{id}")
	public void delete(@PathVariable long id) {
		
		this.iConsommation.delete(id);
	}
	
}
