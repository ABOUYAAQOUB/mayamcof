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

import com.mayamcof.IService.IContrat;
import com.mayamcof.model.Contrat;


@RestController
@RequestMapping("/mayamcof")
public class ContratController {

	private IContrat iContrat;

	public ContratController(IContrat iContrat) {
		
		this.iContrat = iContrat;
	}
	
	@GetMapping("/contrats")
	public List<Contrat>getAll(){
		
		return this.iContrat.getAll();
	}
	
	@GetMapping("/contratByterrain/{id}")
	public Contrat getContratbyterrain(@PathVariable long id) {
		
		return this.iContrat.getContratByTerrainId(id);
	}
	
	@GetMapping("/contrat/{id}")
	public Contrat getContrat(@PathVariable long id) {
		
		return this.iContrat.getContrat(id);
	}
	
	@PostMapping("/contrat")
	public Contrat create(@RequestBody Contrat contrat) {
		
		return this.iContrat.create(contrat);
	}
	
	@PutMapping("/contrat")
	public Contrat update(@RequestBody Contrat contrat) {
		
		return this.iContrat.update(contrat);
	}
	
	@DeleteMapping("/contrat/{id}")
	public void delete(@PathVariable long id) {
		
		this.iContrat.delete(id);
	}
}
