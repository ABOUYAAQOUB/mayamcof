package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	@Query("Select c from Client c WHERE c.cin=:CIN")
	Client findByCIN(@Param("CIN") String CIN);
	
	@Query("Select c from Client c WHERE c.email=:Email")
	Client findByEmail(@Param("Email") String email);
}
