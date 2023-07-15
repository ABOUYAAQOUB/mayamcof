package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long>{

	@Query("select t from Tache t where t.libele = :libele")
	Tache getByLibele (@Param("libele") String libele);
}
