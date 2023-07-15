package com.mayamcof.IService;

import java.util.List;

import com.mayamcof.model.Construction;

public interface IConstruction {

	public List<Construction>getAll();
	public Construction getConstruction(Long id);
	public Construction create(Construction construction);
	public Construction update(Construction construction);
	public void delete(Long id);
}
