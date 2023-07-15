package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{

	@Query("select f from Fournisseur f where f.ICE = :ICE")
	Fournisseur getByICE(@Param("ICE") String ICE);
}
