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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fournisseurs")
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// doit etre non null 
	private String nom;
	// no contient pas des chaines de caracter et la taille 14 
	private String tel;
	// oblegatoire et egale 15 numeros
	private String ICE;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "fournisseur",targetEntity=Commande.class,cascade = CascadeType.ALL)
	protected List<Commande> Commande;
}
