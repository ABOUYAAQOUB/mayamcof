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
@Table(name = "taches")
public class Tache {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// ne doit pas etre null
	private String libele;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "tache",targetEntity=Construction.class,cascade = CascadeType.ALL)
	protected List<Construction> constructions;
}
