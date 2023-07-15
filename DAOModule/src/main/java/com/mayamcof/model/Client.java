package com.mayamcof.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cin;
	//non vide 
	private String nom;
	// contient @ et .
	private String email;
	// no contient pas des chaines de caracter et la taille 14 
	private String tel;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "client",targetEntity=Terrain.class,cascade = CascadeType.ALL)
	protected List<Terrain> terrains;
}
