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

import com.mayamcof.IService.IConstruction;
import com.mayamcof.model.Construction;


@RestController
@RequestMapping("/mayamcof")
public class ConstructionController {

	private IConstruction iConstruction;

	public ConstructionController(IConstruction iConstruction) {
		
		this.iConstruction = iConstruction;
	}
	
	@GetMapping("/constructions")
	public List<Construction>getAll(){
		
		return this.iConstruction.getAll();
	}
	
	@GetMapping("/constructions/{id}")
	public List<Construction>getAll(@PathVariable Long id){
		
		return this.iConstruction.getAll(id);
	}
	
	@GetMapping("/construction/{id}")
	public Construction getConstructions(@PathVariable Long id){
		
		return this.iConstruction.getConstruction(id);
	}
	
	@PostMapping("/construction")
	public Construction create(@RequestBody Construction construction){
		
		return this.iConstruction.create(construction);
	}
	
	@PutMapping("/construction")
	public Construction update(@RequestBody Construction construction){
		
		return this.iConstruction.update(construction);
	}
	
	@DeleteMapping("/construction/{id}")
	public void delete(@PathVariable long id){
		
		this.iConstruction.delete(id);
	}
}
