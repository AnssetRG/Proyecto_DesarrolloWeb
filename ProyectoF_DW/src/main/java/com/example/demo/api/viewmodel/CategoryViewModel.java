package com.example.demo.api.viewmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CategoryViewModel {

	private Long idCategory;
	
	@NotNull
	@Min(3)
	private String name;

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
