package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayamcof.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
