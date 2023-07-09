package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayamcof.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long>{

}
