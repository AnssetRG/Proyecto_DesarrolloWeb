package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;
import com.example.demo.model.Species;


@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.at-query
	@Query("SELECT n FROM Species n WHERE n.category.idCategory=?1")
	List<Species> getAllByCategory(Long id);	

	List<Species> findAllByCategory(Category categories);
}
