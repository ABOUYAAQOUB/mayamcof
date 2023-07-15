package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

	@Query("select p from Produit p where p.nom = :nom")
	Produit getByNom(@Param("nom") String nom);
}
