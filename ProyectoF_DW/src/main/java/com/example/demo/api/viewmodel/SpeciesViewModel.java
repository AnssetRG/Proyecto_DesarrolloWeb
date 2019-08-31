package com.example.demo.api.viewmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SpeciesViewModel {

	private Long idSpecies;
	
	@NotNull
	@Min(3)
	private String name;
	
	private Long idCategory;

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

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}
	
	
}
