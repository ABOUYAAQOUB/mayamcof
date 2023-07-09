package com.mayamcof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consommations")
public class Consommation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name = "construction_id")
	private Construction construction;
}
