package com.mayamcof.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contrats")
public class Contrat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date datecontrat;
	// la taille ne depace pas deux mega
	@Column(columnDefinition = "mediumtext")
	private String contratpdf;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "terrain_id", referencedColumnName = "id")
	private Terrain terrain;
}
