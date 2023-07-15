package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.IEmployer;
import com.mayamcof.Repository.EmployerRepository;
import com.mayamcof.model.Employer;

@Service
public class EmployerService implements IEmployer{
	
	private EmployerRepository employerRepository;

	public EmployerService(EmployerRepository employerRepository) {
		
		this.employerRepository = employerRepository;
	}

	@Override
	public List<Employer> getAll() {
		
		return this.employerRepository.findAll();
	}

	@Override
	public Employer getEmployer(Long id) {
		
		return this.employerRepository.findById(id).get();
	}

	@Override
	public Employer create(Employer employer) {
		
		return this.employerRepository.save(employer);
	}

	@Override
	public Employer update(Employer employer) {

		Employer employerUpdated = this.employerRepository.findById(employer.getId()).get();
		
		employerUpdated.setNom(employer.getNom());
		employerUpdated.setSalaire(employer.getSalaire());
		employerUpdated.setType(employer.getType());
		employerUpdated.setTravaillers(employer.getTravaillers());
		
		return this.employerRepository.save(employerUpdated);
	}

	@Override
	public void delete(Long id) {
		
		this.employerRepository.delete(this.employerRepository.findById(id).get());
	}

}
