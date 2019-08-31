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
import com.example.demo.api.viewmodel.ProviderViewModel;
import com.example.demo.model.Provider;
import com.example.demo.repository.ProviderRepository;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@Autowired
	private Mapper mapper;

	@GetMapping
	public List<ProviderViewModel> all(){
		List<Provider> providers = this.providerRepository.findAll();
		List<ProviderViewModel> providerViewModel = providers.stream().map(provider->this.mapper.convertToProviderViewModel(provider)).collect(Collectors.toList());
		return providerViewModel;
	}
	
	@GetMapping("/{id}")
	public ProviderViewModel byId(@PathVariable Long id) {
		Provider provider = this.providerRepository.findById(id).orElse(null);
		if(provider==null) {
			throw new EntityNotFoundException();
		}
		ProviderViewModel providerViewModel = this.mapper.convertToProviderViewModel(provider);
		return providerViewModel;
	}
	
	@GetMapping("/byUSer/{idUser}")
	public List<ProviderViewModel> byUser(@PathVariable Long idUser){
		List<Provider> providers = new ArrayList<>();
		providers = this.providerRepository.getAllByUser(idUser);
		List<ProviderViewModel> providerViewModel = providers.stream().map(provider->this.mapper.convertToProviderViewModel(provider)).collect(Collectors.toList());
		return providerViewModel;
	}
	
	@PostMapping
	public Provider save(@RequestBody ProviderViewModel providerViewModel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Provider providerEntity = this.mapper.converToProviderEntity(providerViewModel);
		this.providerRepository.save(providerEntity);
		return providerEntity;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.providerRepository.deleteById(id);
	}
}
