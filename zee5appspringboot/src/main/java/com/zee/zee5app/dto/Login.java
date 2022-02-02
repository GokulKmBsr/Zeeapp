package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

//import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.Setter;

@Data

@Entity //entity class is used for ORM 
//can we custamize the table name
@Table(name = "login")
@AllArgsConstructor

public class Login implements Comparable<Login>{
	@Id
	@Column(name="username")
	private String userName;
	
	@NotNull
	private String password;
	
	@NotBlank
	private String regId;
	
	private ROLE role;
	

	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return this.regId.compareTo(o.getRegId());
	}
	
 

}