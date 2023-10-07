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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "constructions")
public class Construction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String unite;
	private int quantite;
	private float prix;
	private boolean confirmer;
	
	@ManyToOne
	@JoinColumn(name = "terrain_id")
	private Terrain terrain;
	
	@ManyToOne
	@JoinColumn(name = "tache_id")
	private Tache tache;
	
	@ManyToOne
	@JoinColumn(name = "facture_id")
	private Facture facture;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "construction",targetEntity=Consommation.class,cascade = CascadeType.ALL)
	protected List<Consommation> consommations;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "construction",targetEntity=Travailler.class,cascade = CascadeType.ALL)
	protected List<Travailler> travaillers;
}
