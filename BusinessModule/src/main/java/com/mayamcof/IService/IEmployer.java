package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Employer;

public interface IEmployer {

	public List<Employer>getAll();
	public Employer getEmployer(Long id);
	public Employer create(Employer employer);
	public Employer update(Employer employer);
	public void delete(Long id);
}
