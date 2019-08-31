package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="species")
public class Species {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSpecies;
	
	private String name;
	
	@ManyToOne
	private Category category;
	
	public Species() {
		
	}
	


	public Species(Long idSpecies, String name, Category category) {
		this.idSpecies = idSpecies;
		this.name = name;
		this.category = category;
	}



	public Long getIdSpecies() {
		return idSpecies;
	}

	public void setIdSpecies(Long idSpecies) {
		this.idSpecies = idSpecies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}

}
