package com.zee.zee5app.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "login")
public class Login implements Comparable<Login>{
	
	@Id
	@Column(name = "username")
	private String userName;
	
	private String password;
	private String regId;
	//private ROLE role;
	//private Role role;
	

	@Override
	public int compareTo(Login o) {
		// TODO Auto-generated method stub
		return this.regId.compareTo(o.getRegId());
	}
	
 

}