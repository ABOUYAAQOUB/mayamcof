package com.mayamcof.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "terrains")
public class Terrain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// 0 > 
	private float surface;
	// R+2 -> R+6
	private String etage;
	// non null
	private String adresse;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "terrain",targetEntity=Construction.class,cascade = CascadeType.ALL)
	protected List<Construction> constructions;
	
	@JsonIgnore
	@OneToOne(mappedBy = "terrain",cascade = CascadeType.ALL)
	private Contrat contrat;
}
