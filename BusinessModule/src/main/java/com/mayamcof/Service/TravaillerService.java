package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.ITravailler;
import com.mayamcof.Repository.TravaillerRepository;
import com.mayamcof.model.Travailler;

@Service
public class TravaillerService implements ITravailler {
	
	private TravaillerRepository repository;
	
	public TravaillerService(TravaillerRepository repository) {
		this.repository=repository;
	}

	@Override
	public List<Travailler> getAll() {
		 return repository.findAll();
	}

	@Override
	public Travailler getTravailler(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Travailler create(Travailler Travailler) {
		return repository.save(Travailler);
	}

	@Override
	public Travailler update(Travailler Travailler) {
		return repository.save(Travailler);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);		
	}
	
	@Override
	public Travailler getByConstruction(Long id) {
		return repository.findByConstruction(id);
	}

}
