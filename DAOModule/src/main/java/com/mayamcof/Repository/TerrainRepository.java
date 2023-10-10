package com.mayamcof.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mayamcof.model.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain, Long>{

	@Query("select t from Terrain t where t.id not in (select t.id from Terrain t, Contrat c where t.id = c.terrain.id)")
	List<Terrain> getTerrainNotContrat();
	
	@Query("select t from Terrain t where t.id not in (select t.id from Terrain t, Contrat c where c.id!=:id and t.id = c.terrain.id )")
	List<Terrain> getTerrainUpdate(@Param("id") Long id);
}
