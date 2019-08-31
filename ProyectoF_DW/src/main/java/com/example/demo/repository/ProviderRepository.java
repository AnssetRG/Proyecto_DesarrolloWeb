package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Provider;
import com.example.demo.model.User;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{

	@Query("SELECT n FROM Provider n WHERE n.user.idUser=?1")
	List<Provider> getAllByUser(Long id);
	List<Provider>findAllByUser(User user);
}
