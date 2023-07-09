package com.mayamcof.model;

import java.util.Date;

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
@Table(name = "travaillers")
public class Travailler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date datedebut;
	private Date datefin;
	
	@ManyToOne
	@JoinColumn(name = "terrain_id")
	private Terrain terrain;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
}
