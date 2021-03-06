package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "episodename")}, name = "episode")
public class Episode implements Comparable<Movie> {
	
	@Id
	@Column(name = "id")
	@Length(min = 6)
	private String id;
	@NotBlank
	private String episodename;
	private int length;
//	@NotBlank
//	private String seriesid;
	@NotBlank
	private String location;
	private String trailer;

	@Override
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	@ManyToOne
	//this episode table should have FK.seriesid
	@JoinColumn(name="seriesid")
	private Series series; //it should take series id,and that column should act as foreign key column

}