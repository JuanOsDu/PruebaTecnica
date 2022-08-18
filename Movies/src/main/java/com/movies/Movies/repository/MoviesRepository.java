	package com.movies.Movies.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.movies.Movies.model.Movies;

public interface MoviesRepository extends MongoRepository<Movies,Integer>{
	
	@Query("{'ID':?0}")
	public List<Movies> findByID(int id);
	
	
	
	
	
}
