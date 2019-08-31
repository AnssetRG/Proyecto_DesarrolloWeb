package com.example.demo.model;

import java.util.ArrayList;
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

@Entity
@Table(name="categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idCategory;
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Species> species;

	
	public Category() {
		species = new ArrayList<Species>();
	}
	
	
	
	public Category(Long idCategory, String name) {
		super();
		this.idCategory = idCategory;
		this.name = name;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Species> getSpecies() {
		return species;
	}

	public void setSpecies(List<Species> species) {
		this.species = species;
	}



	public Long getIdCategory() {
		return idCategory;
	}



	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	
	
}
