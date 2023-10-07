package com.mayamcof.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.Consommation;

public interface ConsommationRepository extends JpaRepository<Consommation, Long>{
	
	@Query("Select c from Consommation c WHERE c.construction.id=:id")
	List<Consommation> findByConstruction(@Param("id") long id);

}
