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

import com.mayamcof.IService.IEmployer;
import com.mayamcof.model.Employer;


@RestController
@RequestMapping("/mayamcof")
public class EmployerController {

	private IEmployer iEmployer;
	
	
	public EmployerController(IEmployer iEmployer) {
		
		this.iEmployer = iEmployer;
	}

	@GetMapping("/employers")
	public List<Employer>getAll(){
		
		return this.iEmployer.getAll();
	}
	
	@GetMapping("/employer/{id}")
	public Employer getEmployer(@PathVariable long id) {
		
		return this.iEmployer.getEmployer(id);
	}
	
	@PostMapping("/employer")
	public Employer create(@RequestBody Employer employer) {
		
		return this.iEmployer.create(employer);
	}
	
	@PutMapping("/employer")
	public Employer update(@RequestBody Employer employer) {
		
		return this.iEmployer.update(employer);
	}
	
	@DeleteMapping("/employer/{id}")
	public void delete(@PathVariable long id) {
		
		this.iEmployer.delete(id);
	}
}
