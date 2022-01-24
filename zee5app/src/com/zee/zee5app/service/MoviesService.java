package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movies;

public interface MoviesService {
	public String addMovies(Movies movies);
	public String updateMovies(String id, Movies movies);
	public Movies getMoviesById(String id);
	public Movies[] getMovies();
	public String deleteMovies(String id);

}
