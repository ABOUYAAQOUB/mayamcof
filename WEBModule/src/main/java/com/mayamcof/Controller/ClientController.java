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

import com.mayamcof.model.Client;

@CrossOrigin("*")
@RestController
@RequestMapping("/mayamcof")
public class ClientController {

	@GetMapping("/clients")
	public List<Client>getAll(){
		return null;
	}
	
	@GetMapping("/client/{id}")
	public Client getClient(@PathVariable long id) {
		return null;
	}
	
	@PostMapping("/client")
	public String create(@RequestBody Client client) {
		return null;
	}
	
	@PutMapping("/client")
	public String update(@RequestBody Client client) {
		return null;
	}
	
	@DeleteMapping("/client/{id}")
	public String delete(@PathVariable Long id) {
		return null;
	}
}
