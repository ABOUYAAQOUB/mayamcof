package com.mayamcof.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayamcof.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
