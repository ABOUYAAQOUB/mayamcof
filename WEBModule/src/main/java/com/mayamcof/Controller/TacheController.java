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

import com.mayamcof.IService.ITache;
import com.mayamcof.model.Tache;


@RestController
@RequestMapping("/mayamcof")
public class TacheController {
	
	private ITache tache;
	
	public TacheController(ITache tache) {
		this.tache=tache;
	}
	
	@GetMapping("/taches")
	public List<Tache>getAll(){
		return this.tache.getAll();
	}
	
	@GetMapping("/tache/{id}")
	public Tache getClient(@PathVariable long id) {
		return this.tache.getTache(id);
	}
	
	@PostMapping("/tache")
	public Tache create(@RequestBody Tache tache) {
		return this.tache.create(tache);
	}
	
	@PutMapping("/tache")
	public Tache update(@RequestBody Tache tache) {
		return this.tache.update(tache);
	}
	
	@DeleteMapping("/tache/{id}")
	public void delete(@PathVariable Long id) {
		this.tache.delete(id);
	}

}
