package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	Boolean existsByMoviename(String moviename);
	//retrieve details based on moviename and language -->findBy word
	//boolean result ->exists
	
	Optional<Movie> findByMovienameAndLanguage(String moviename,String language);
	
	Optional<Movie> findByMoviename(String moviename);
	
	Optional<Movie> findByMovienameAndReleaseDate(String moviename,String releaseDate);
	
	List<Movie> findByCast(String cast);
	

}
