package com.zee.zee5app.dto;

import java.net.URL;
import java.lang.*;
import java.util.Objects;
import javax.naming.NameNotFoundException;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString

@Entity //entity class is used for ORM 
//can we custamize the table name
//@Table(name = "movie")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "movieName")},name = "movies")
@AllArgsConstructor
public class Movie implements Comparable<Movie>{
	
	
//	public Movie(String id, String movieName, String cast, String length, String releaseDate, String trailer,
//			String language, String ageLimit, String genre) throws InvalidIdLengthException, NameNotFoundException {
//		super();
//		this.setId(id);
//		this.setMovieName(movieName);
//		this.setAgeLimit(ageLimit);
//		this.setCast(cast);
//		this.setGenre(genre);
//		
//		this.setLength(length);
//		this.setReleaseDate(releaseDate);
//		this.setTrailer(trailer);
//		this.setLanguage(language);
//	}
//	
//	public Movie() {
//		
//	}


	@Id
	//@Setter(value = AccessLevel.NONE)
	private String id;
	
	//@Setter(value = AccessLevel.NONE)
	private String movieName;
	
	private int length;
	@NotBlank
	private String genre;
	@NotBlank
	private String releaseDate;
	@NotBlank
	private String trailer;
	@NotBlank
	private String Cast;
	@Max(value = 70)
	private String ageLimit;
	@NotBlank
	private String language;
	
	


	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

//	public void setId(String id) throws InvalidIdLengthException {
//		if(id.length()<6) {
//			throw new InvalidIdLengthException("id length less than 6");
//		}
//		this.id = id;
//
//	}
//
//	public void setMovieName(String movieName) throws NameNotFoundException {
//		if(movieName == null) {
//			throw new NameNotFoundException("movie name not found");
//		}
//		this.movieName = movieName;
//	}

//	public void setCast(String[] string) {
//		// TODO Auto-generated method stub
//		this.Cast = Cast;
//	}
//	
}