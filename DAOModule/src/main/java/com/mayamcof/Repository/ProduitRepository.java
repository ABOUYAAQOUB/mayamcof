package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayamcof.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
