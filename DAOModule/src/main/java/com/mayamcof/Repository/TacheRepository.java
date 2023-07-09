package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayamcof.model.Tache;

public interface TacheRepository extends JpaRepository<Tache, Long>{

}
