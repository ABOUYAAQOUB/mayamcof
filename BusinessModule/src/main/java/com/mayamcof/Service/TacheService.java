package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.ITache;
import com.mayamcof.Repository.TacheRepository;
import com.mayamcof.exception.UniqueException;
import com.mayamcof.model.Tache;

@Service
public class TacheService implements ITache{

		private TacheRepository tacheRepository;
		
		public TacheService(TacheRepository repository) {
			this.tacheRepository= repository;
		}
	
	@Override
	public List<Tache> getAll() {
       return this.tacheRepository.findAll();
	}

	@Override
	public Tache getTache(Long id) {
		return this.tacheRepository.findById(id).orElse(null);
	}

	@Override
	public Tache create(Tache tache) {
		
		if(this.tacheRepository.getByLibele(tache.getLibele()) == null) {
			return this.tacheRepository.save(tache);
		}else {
			throw new UniqueException("Tache deja existe", "0000", "Libele");
		}
		
	}

	@Override
	public Tache update(Tache tache) {
		
		if(this.tacheRepository.getByLibele(tache.getLibele()) == null || this.tacheRepository.getByLibele(tache.getLibele()).getId() == tache.getId()) {
			
			return this.tacheRepository.save(tache);
		}else {
			
			throw new UniqueException("Tache deja existe", "0000", "Libele");
		}
		
	}

	@Override
	public void delete(Long id) {
		this.tacheRepository.deleteById(id);
	}

}
