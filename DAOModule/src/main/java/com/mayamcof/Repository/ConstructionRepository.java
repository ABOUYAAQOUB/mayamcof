package com.mayamcof.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.mayamcof.model.Construction;


public interface ConstructionRepository extends JpaRepository<Construction, Long>{
	@Query("Select c from Construction c WHERE c.terrain.id=:id")
	List<Construction> findByTerrain(@Param("id") long id);
}
