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

import com.mayamcof.IService.ITravailler;
import com.mayamcof.model.Travailler;


@RestController
@RequestMapping("/mayamcof")
public class TravaillerController {
	
	private ITravailler travailler;
	
	public TravaillerController(ITravailler travailler) {
		this.travailler= travailler;
	}
	
	@GetMapping("/travaillers")
	public List<Travailler>getAll(){
		return this.travailler.getAll();
	}
	
	@GetMapping("/travailler/{id}")
	public Travailler getTravailler(@PathVariable long id) {
		return this.travailler.getTravailler(id);
	}
	
	@PostMapping("/travailler")
	public Travailler create(@RequestBody Travailler Travailler) {
		return this.travailler.create(Travailler);
	}
	
	@PutMapping("/travailler")
	public Travailler update(@RequestBody Travailler Travailler) {
		return this.travailler.create(Travailler);
	}
	
	@DeleteMapping("/travailler/{id}")
	public void delete(@PathVariable Long id) {
		this.travailler.delete(id);
	}
	
	@GetMapping("/travaillers/{id}")
	public Travailler getByConstruction(@PathVariable Long id) {
		return this.travailler.getByConstruction(id);
	}

}
