package com.mayamcof.model;

import java.util.Date;
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
@Table(name = "commandes")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date datecommande;
	
	@ManyToOne
	@JoinColumn(name = "fournisseur_id")
	private Fournisseur fournisseur;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "commande",targetEntity=DetailCommande.class,cascade = CascadeType.ALL)
	protected List<DetailCommande> DetailCommandes;
}
