package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movies;

public class MoviesRepository2 {
	
	private Movies[] movies = new Movies[10];
	private static int count=-1;
	private MoviesRepository2() {
		// TODO Auto-generated constructor stub
	}

	public Movies[] getMovies() {
		return movies;
	}

	public String deleteMovies(String id) {
		return null;
	}

	
	public String updateMovies(String id , Movies movie) {
		movies[++count]=movie;
		return "added";
	}
	
	public Movies getMoviesById(String id) {
		
		for (Movies movie : movies) {
			if(movie!=null && movie.getId().equals(id) ) {
				return movie;
			}
		}
		
		return null;
		
	}
	
	// add a new user
	public String addMovies(Movies movie) {
		

		if(count==movies.length-1) {

			Movies temp[] = new Movies[movies.length*2];
			
			System.arraycopy(movies, 0, temp, 0, movies.length);
			movies= temp;
			movies[++count] = movie;
			
			
			return "success";
			
		}
		movies[++count] = movie;
		return "success";
		
				
		
	}
	private static MoviesRepository2 moviesRepository;
	public static MoviesRepository2 getInstance() {
		
		if(moviesRepository==null)
			moviesRepository = new MoviesRepository2();
		return moviesRepository;
		
	}

}
