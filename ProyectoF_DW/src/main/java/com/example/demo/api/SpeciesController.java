package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper;
import com.example.demo.api.viewmodel.SpeciesViewModel;
import com.example.demo.model.Species;
import com.example.demo.repository.SpeciesRepository;




@RestController
@RequestMapping("/api/species")
public class SpeciesController {
	@Autowired
	private SpeciesRepository speciesRepository;

	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<SpeciesViewModel> all() {
		List<Species> species = this.speciesRepository.findAll();

		// map from entity to view model
		List<SpeciesViewModel> speciesViewModel = species.stream().map(specie -> this.mapper.convertToSpeciesViewModel(specie))
				.collect(Collectors.toList());

		return speciesViewModel;
	}

	@GetMapping("/{id}")
	public SpeciesViewModel byId(@PathVariable Long id) {
		Species specie = this.speciesRepository.findById(id).orElse(null);

		if (specie == null) {
			throw new EntityNotFoundException();
		}

		SpeciesViewModel speciesViewModel = this.mapper.convertToSpeciesViewModel(specie);

		return speciesViewModel;
	}

	@GetMapping("/byCategory/{categoryId}")
	public List<SpeciesViewModel> byCategory(@PathVariable Long categoryId) {
		List<Species> species = new ArrayList<>();

//		Optional<Notebook> notebook = this.notebookRepository.findById(categoryId);
	//	if (notebook.isPresent()) {
			//species = this.speciesRepository.findAllByNotebook(notebook.get());
			species = this.speciesRepository.getAllByCategory(categoryId);
		//}

		// map to specie view model
		List<SpeciesViewModel> speciesViewModel = species.stream()
				.map(specie -> this.mapper.convertToSpeciesViewModel(specie))
				.collect(Collectors.toList());

		return speciesViewModel;
	}

	@PostMapping
	public Species save(@RequestBody SpeciesViewModel speciesCreateViewModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		Species speciesEntity = this.mapper.convertToEspeciesEntity(speciesCreateViewModel);

		// save specie instance to db
		this.speciesRepository.save(speciesEntity);

		return speciesEntity;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.speciesRepository.deleteById(id);
	}


}
