package com.movies.Movies.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.movies.Movies.model.Movies;
import com.movies.Movies.repository.MoviesRepository;
import com.movies.Movies.response.SimpleResponse;
import com.movies.Movies.services.MoviesService;

@Service
public class MoviesImp implements MoviesService {

	@Autowired
	private MoviesRepository mv;

	@Override
	public ResponseEntity<?> getAll(Integer total, String order) {
		// TODO Auto-generated method stub
		try {

			if (order.equalsIgnoreCase("ASC")) {

				return ResponseEntity.ok(mv.findAll(Sort.by(Sort.Direction.ASC, "Film")).subList(0, total));
			} else if (order.equalsIgnoreCase("DESC")) {
				return ResponseEntity.ok(mv.findAll(Sort.by(Sort.Direction.DESC, "Film")).subList(0, total));
			} else {
				return ResponseEntity.ok(mv.findAll());
			}
		} catch (IndexOutOfBoundsException ex) {
			if (order.equalsIgnoreCase("ASC")) {

				return ResponseEntity.ok(mv.findAll(Sort.by(Sort.Direction.ASC, "Film")));
			} else  {
				return ResponseEntity.ok(mv.findAll(Sort.by(Sort.Direction.DESC, "Film")));
			}
		} catch (Exception e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Procesando solicitud");
		}

	}

	@Override
	public ResponseEntity<?> getByID(Integer id) {
		// TODO Auto-generated method stub
		try {
			return ResponseEntity.ok(mv.findByID(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Procesando solicitud");
		}
	}

	@Override
	public ResponseEntity<?> insertOne(Movies movie) {
		// TODO Auto-generated method stub
		try {
			Movies response = mv.save(movie);
			if (response.getID() == 0) {
				return ResponseEntity.ok(new SimpleResponse("No se pudo crear la pelicula"));
			}
			return ResponseEntity.ok(new SimpleResponse("La película fue creada con éxito"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Procesando solicitud");
		}
	}

}
