package com.mayamcof.model;

import java.util.Date;
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
@Table(name = "factures")
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//contient la date d'aujourd'hui
	private Date datefacture;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "facture",targetEntity=Construction.class,cascade = CascadeType.ALL)
	protected List<Construction> constructions;
	
}
