package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.api.viewmodel.ProviderViewModel;
import com.example.demo.api.viewmodel.SpeciesViewModel;
import com.example.demo.model.Category;
import com.example.demo.model.Provider;
import com.example.demo.model.Species;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.UserRepository;



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
	
	@Autowired
	private UserRepository userRepository;
	
	public ProviderViewModel convertToProviderViewModel(Provider entity) {
		ProviderViewModel viewModel = new ProviderViewModel();
		viewModel.setIdProvider(entity.getIdProvider());
		viewModel.setBusinessName(entity.getBusinessName());
		viewModel.setDocumentNumber(entity.getDocumentNumber());
		viewModel.setDocumentType(entity.getDocumentType());
		viewModel.setIdUser(entity.getUser().getIdUser());
		viewModel.setPhoneNumber(entity.getPhoneNumber());
		return viewModel;
	}
	
	public Provider converToProviderEntity(ProviderViewModel viewModel) {
		User user = this.userRepository.findById(viewModel.getIdUser()).get();
		Provider entity = new Provider(viewModel.getIdProvider(),viewModel.getDocumentType(),viewModel.getBusinessName(),viewModel.getDocumentNumber(),
				viewModel.getPhoneNumber(),user);
		return entity;
	}
}
