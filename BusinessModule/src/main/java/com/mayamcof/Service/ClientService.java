package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IClient;
import com.mayamcof.model.Client;

@Service
public class ClientService implements IClient{

	@Override
	public List<Client> getAll() {
		
		return null;
	}

	@Override
	public Client getClient(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
