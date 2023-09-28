package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IClient;
import com.mayamcof.Repository.ClientRepository;
import com.mayamcof.exception.UniqueException;
import com.mayamcof.model.Client;

@Service
public class ClientService implements IClient{

	private ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository) {
		
		this.clientRepository = clientRepository;
	}

	@Override
	public List<Client> getAll() {
		return this.clientRepository.findAll();
	}

	@Override
	public Client getClient(Long id) {
		
		return this.clientRepository.findById(id).get();
	}

	@Override
	public Client create(Client client) {	
		if(this.clientRepository.findByCIN(client.getCin())==null) {
			if(client.getEmail().isEmpty() || this.clientRepository.findByEmail(client.getEmail())==null ) {
				return this.clientRepository.save(client);
			}else {
				throw new UniqueException("Cette Client deja existe", "6666", "Email");
			}
			
		}else {
			throw new UniqueException("Cette Client deja existe", "6666", "CIN");
		}
		
	}

	@Override
	public Client update(Client client) {
		
		if(this.clientRepository.findByCIN(client.getCin())==null  ||  this.clientRepository.findByCIN(client.getCin()).getId()==client.getId()) {
			if(client.getEmail().isEmpty() || this.clientRepository.findByEmail(client.getEmail())==null ||  this.clientRepository.findByEmail(client.getEmail()).getId()==client.getId()) {
				return this.clientRepository.save(client);
			}else {
				throw new UniqueException("Cette Client deja existe", "6666", "Email");
			}
			
		}else {
			throw new UniqueException("Cette Client deja existe", "6666", "CIN");
		}
	}

	@Override
	public void delete(Long id) {
		
		Client clientDeleted = this.clientRepository.findById(id).get();
		
		this.clientRepository.delete(clientDeleted);
	}

}
