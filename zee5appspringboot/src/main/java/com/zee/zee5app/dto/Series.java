package com.zee.zee5app.dto;

import java.net.URL;
import java.lang.*;
import javax.naming.NameNotFoundException;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Objects;
//@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString

@Entity //entity class is used for ORM 
//can we custamize the table name
//@Table(name = "series")
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "seriesName")},name = "series")
public class Series implements Comparable<Series> {
	
	@Id
	//@Setter(value = AccessLevel.NONE)
	private String id;
	@NotBlank
	// @UniqueConstraint ->no need to add here ,at the top only we added
	private String seriesName;
	
	// private int length; --this is not required
	
	//@Setter(value = AccessLevel.NONE)
	
	@NotBlank
	private String genre;
	@NotNull
	private String releaseDate;
	@NotBlank
	private String trailer;
	@NotBlank
	private String Cast;
	@Max(value = 70)
	private int ageLimit;
	@Min(value = 1)
	private int noofepisodes;
	@NotBlank
	private String language;
	
//	public Series(String id, String seriesName, String cast,  String length, String releaseDate, String trailer,
//			String language, String ageLimit, String genre, int noofepisodes) throws InvalidIdLengthException, NameNotFoundException {
//		super();
//		this.setId(id);
//		this.setSeriesName(seriesName);
//		this.setAgeLimit(ageLimit);
//		this.setCast(cast);
//		this.setGenre(genre);
//		
//		this.setLength(length);
//		this.setReleaseDate(releaseDate);
//		this.setTrailer(trailer);
//		this.setNoofepisodes(noofepisodes);
//		this.setLanguage(language);
//	}
//	
//	public Series() {
//		
//	}


	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}

//	public void setSeriesName(String seriesName) throws NameNotFoundException {
//
//		if(seriesName == null)
//			throw new NameNotFoundException("series name not found");
//		this.seriesName = seriesName;
//	}
//
//	public void setId(String id) throws InvalidIdLengthException {
//		if(id.length()<6)
//			throw new InvalidIdLengthException("id length less than 6");
//		this.id = id;
//	}
	
}