package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.api.viewmodel.SpeciesViewModel;
import com.example.demo.model.Category;
import com.example.demo.model.Species;
import com.example.demo.repository.CategoryRepository;



@Component
public class Mapper {
	@Autowired
	private CategoryRepository categoryRepository;

	public SpeciesViewModel convertToSpeciesViewModel(Species entity) {
		SpeciesViewModel viewModel = new SpeciesViewModel();
		viewModel.setIdSpecies(entity.getIdSpecies());
		viewModel.setName(entity.getName());
		viewModel.setIdCategory(entity.getCategory().getIdCategory());
		return viewModel;
	}

	public Species convertToEspeciesEntity(SpeciesViewModel viewModel) {
		Category category = this.categoryRepository.findById(viewModel.getIdCategory()).get();
		Species entity = new Species(viewModel.getIdSpecies(), viewModel.getName(), category);

		return entity;
	}
}
