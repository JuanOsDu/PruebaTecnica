package com.movies.Movies.model;

import java.io.Serializable;


import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movies implements Serializable {// implements Comparable<Movies> {

	
	//@Id no se puede agregar por problemas con el id autogenerado de mongo
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String Film;
	private String Genre;
	private String Studio;
	private int Score;
	private int Year;

	//@Override
	//public int compareTo(Movies movie) {
		// TODO Auto-generated method stub
	//	return this.Film.compareTo(movie.getFilm());

	//}

}
