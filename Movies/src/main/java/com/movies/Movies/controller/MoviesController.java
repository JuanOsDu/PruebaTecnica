package com.movies.Movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.Movies.model.Movies;
import com.movies.Movies.services.MoviesService;

@RestController
public class MoviesController {

	
	@Autowired
	private MoviesService ms;
	
	@GetMapping(value="/movie", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getByID(Integer id){
		return ms.getByID(id);
	}
	@GetMapping(value="/movies", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getAll(Integer total, String order){
		return ms.getAll(total, order);
	}
	
	@PostMapping(value="/movie", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> insertOne(@RequestBody Movies movie){
		return ms.insertOne(movie);
	}
	
}
