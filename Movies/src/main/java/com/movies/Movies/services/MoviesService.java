package com.movies.Movies.services;

import org.springframework.http.ResponseEntity;

import com.movies.Movies.model.Movies;

public interface MoviesService {
	
	public ResponseEntity<?> getAll(Integer total, String order);
	public ResponseEntity<?> getByID(Integer id);
	public ResponseEntity<?> insertOne(Movies movie);
}
