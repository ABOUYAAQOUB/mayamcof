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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detailcommandes")
public class DetailCommande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// doit etre 0 >
	private float prix;
	// doit etre 0 >
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name = "commande_id")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;
}
