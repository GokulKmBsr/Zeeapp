package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.repository.MovieRepository;
//import com.zee.zee5app.repository.impl.MovieRepositoryImpl;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
		Movie movie2 = movieRepository.save(movie);
		if (movie2 != null) {
			return "Successfully added movie";
		} else {
			return "failed toadd movie";
		}
		//return null;
	}

	@Override
	public String deleteMovie(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional;
		try {
			optional = this.getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				movieRepository.deleteById(id);
				return "movie deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
		//return null;
	}

	@Override
	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id)
			throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
		//return null;
	}

	@Override
	public Optional<List<Movie>> getAllMovie() throws NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
		//return null;
	}

//	private MovieRepository repository = MovieRepositoryImpl.getInstance();
//	private static MovieService service;	
//	
//	public static MovieService getInstance() throws IOException {
//		if(service == null)
//			service = new MovieServiceImpl();
//		return service;
//	}
//	
//    private MovieServiceImpl() throws IOException{
//		
//	}

//	@Override
//	public String addMovie(Movie movie) {
//		// TODO Auto-generated method stub
//		return this.repository.addMovie(movie);
//	}
//
//	@Override
//	public String deleteMovie(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return this.repository.deleteMovie(id);
//	}
//
//	@Override
//	public String modifyMovie(String id, Movie movie) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return this.repository.modifyMovie(id, movie);
//	}
//
//	@Override
//	public Optional<Movie> getMovieById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		return this.repository.getMovieById(id);
//	}
//
//	@Override
//	public Optional<List<Movie>> getAllMovie() throws NameNotFoundException, InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		return this.repository.getAllMovie();
//	}
//    
    
	
//	@Override
//	public String addMovie(Movie movie) {
//		// TODO Auto-generated method stub
//		return this.repository.addMovie(movie);
//	}
//
//	@Override
//	public Movie getMovieById(String id) {
//		// TODO Auto-generated method stub
//		return this.repository.getMovieById(id);
//	}
//
//	@Override
//	public Movie[] getAllMovies() {
//		// TODO Auto-generated method stub
//		return repository.getAllMovie();
//	}

}