package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayamcof.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long>{

}
