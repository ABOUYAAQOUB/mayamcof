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

import com.mayamcof.IService.IClient;
import com.mayamcof.model.Client;

@RestController
@RequestMapping("/mayamcof")
public class ClientController {

	private IClient iClient;
	
	public ClientController(IClient iClient) {
		
		this.iClient = iClient;
	}

	@GetMapping("/clients")
	public List<Client>getAll(){
		
		return this.iClient.getAll();
	}
	
	@GetMapping("/client/{id}")
	public Client getClient(@PathVariable long id) {
		
		return this.iClient.getClient(id);
	}
	
	@PostMapping("/client")
	public Client create(@RequestBody Client client) {
		
		return this.iClient.create(client);
	}
	
	@PutMapping("/client")
	public Client update(@RequestBody Client client) {
		
		return this.iClient.update(client);
	}
	
	@DeleteMapping("/client/{id}")
	public void delete(@PathVariable Long id) {
		
		this.iClient.delete(id);
	}
}
