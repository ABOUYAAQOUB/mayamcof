package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Client;

public interface IClient {

	public List<Client>getAll();
	public Client getClient(Long id);
	public Client create(Client client);
	public Client update(Client client);
	public String delete(Long id);
}
