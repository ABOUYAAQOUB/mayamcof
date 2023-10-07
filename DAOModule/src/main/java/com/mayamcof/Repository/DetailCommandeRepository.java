package com.mayamcof.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.DetailCommande;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Long>{

	@Query("select d from DetailCommande d where d.commande.id = :id")
	List<DetailCommande> getDetailByCommande(@Param("id") Long id);
}
