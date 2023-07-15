package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.ITache;
import com.mayamcof.Repository.TacheRepository;
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
		return this.tacheRepository.save(tache);
	}

	@Override
	public Tache update(Tache tache) {
		return this.tacheRepository.save(tache);
	}

	@Override
	public void delete(Long id) {
		this.tacheRepository.deleteById(id);
	}

}
