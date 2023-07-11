package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IClient;
import com.mayamcof.Repository.ClientRepository;
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
		
		return this.clientRepository.save(client);
	}

	@Override
	public Client update(Client client) {
		
		Client clientUpdated = this.clientRepository.findById(client.getId()).get();
		
		clientUpdated.setEmail(client.getEmail());
		clientUpdated.setNom(client.getNom());
		clientUpdated.setTel(client.getTel());
		client.setTerrains(client.getTerrains());
		
		return this.clientRepository.save(clientUpdated);
	}

	@Override
	public void delete(Long id) {
		
		Client clientDeleted = this.clientRepository.findById(id).get();
		
		this.clientRepository.delete(clientDeleted);
	}

}
