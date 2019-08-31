package com.example.demo.api;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> all(){
		List<User> users = this.userRepository.findAll();
		return users;
	}
	
	@PostMapping
	public User save(@RequestBody User user,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		
		User userNew = this.userRepository.save(user);
		return userNew;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.userRepository.deleteById(id);
	}
}
