package com.example.demo.api;

import java.util.List;

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

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	
	@GetMapping
	public List<Category> all() {
		List<Category> categories = this.categoryRepository.findAll();
		return categories;
	}

	@PostMapping
	public Category save(@RequestBody Category category, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}

		
		Category categoryNew=this.categoryRepository.save(category);

		return categoryNew;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.categoryRepository.deleteById(id);
	}

}
