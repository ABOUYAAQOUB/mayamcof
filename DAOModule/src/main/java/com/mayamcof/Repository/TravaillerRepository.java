package com.mayamcof.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.Travailler;

public interface TravaillerRepository extends JpaRepository<Travailler, Long>{
	@Query("Select t from Travailler t WHERE t.construction.id =:id_construction")
	List<Travailler> findByConstruction(@Param("id_construction") Long id_construction);
}
