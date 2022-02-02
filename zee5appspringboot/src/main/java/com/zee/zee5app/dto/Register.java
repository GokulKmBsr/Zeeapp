package com.zee.zee5app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import java.lang.*;
import java.math.BigDecimal;
import java.math.BigInteger;

//write @Data and then press ctrl+space then enter to get the lombok
//@Data
@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor

//we use this method to override instead of other one used below coz when we change anything later, it can handle on its own
@EqualsAndHashCode
@ToString

//ORM mapping purpose
@Entity //entity class is used for ORM 
//can we custamize the table name
@Table(name = "register")

@AllArgsConstructor

public class Register implements Comparable<Register>{
//public class Register {
	//add contact number field
//	public Register(String id, String firstName, String lastName, String email, String password, BigDecimal contactnumber) 
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		super();
// 		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//		this.setContactnumber(contactnumber);	
//		}
//	
//	public Register(String id, String firstName, String lastName, String email, String password) 
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		super();
// 		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//			
//		}

	//@Setter(value = AccessLevel.NONE)
	@Id //it will consider this column as pk
	@Column(name = "regId")
	private String id;
	// id value should have min length of 6
	// we have to write a code to validate the length and assign the value
	
	//@Setter(value = AccessLevel.NONE)
	@Size(max=50)
	@NotBlank
	private String firstName;
	
	@Size(max=50)
	@NotBlank
	//@Setter(value = AccessLevel.NONE)
	private String lastName;
	
	//@Setter(value = AccessLevel.NONE)
	@Size(max=50)
	@Email
	private String email;
	
	//@Setter(value = AccessLevel.NONE)
	@Size(max=100)
	@NotBlank
	private String password;
	
	// @Size(max=50) ,because it is bigdecimal ,so not specifiying the size
	@NotBlank
	private BigDecimal contactnumber;
	
//	public Register() {
//		//Explicit Default Constructor
//		// any kind of customization during the initialization of object then its better
//		// to introduce ECD or PC or both as per need.
//		//System.out.println("hello");
//	}

	//here Main is caller for this
//	public void setId(String id) throws InvalidIdLengthException {
//		//throws: it will provide the list of exceptions may be raised
//		// it will hold the list of checked exceptions
//		
//		if(id.length()<6) {
//			//it should raise InvalidIdLengthException
//			// in previous scenarios(frameworkstrategy) exception obj is created by JVM as they were pre-defined
//			
//			//but we have made our own exception now
//			//user defined exception obj must be raised by us
//			throw new InvalidIdLengthException("id length is less than 6");
//			
//		}
//		this.id = id;
//	}
//
//	public void setFirstName(String firstName) throws InvalidNameException {
//		if(firstName ==null || firstName=="" || firstName.length()<2) {
//			throw new InvalidNameException("first name is not valid");
//		}
//		this.firstName = firstName;
//	}
//
//	public void setLastName(String lastName) throws InvalidNameException {
//		if(lastName ==null || lastName=="" || lastName.length()<2) {
//			throw new InvalidNameException("last name is not valid");
//		}
//		this.lastName = lastName;
//	}
//
//	public void setEmail(String email) throws InvalidEmailException {
//		//check for email ending with and @
//		if(email.endsWith(".com")==false || email.indexOf("@")==-1)
//			throw new InvalidEmailException("email invalid");
//		this.email = email;
//	}
//
//	public void setPassword(String password) throws InvalidPasswordException {
//		if(password == null)
//			throw new InvalidPasswordException("password should be there");
//		this.password = password;
//	}

	@Override
	public int compareTo(Register o) {
		 //TODO Auto-generated method stub
		//ascending
		return this.id.compareTo(o.getId());
		
		//descending order
		//return o.id.compareTo(this.getId())
	}
	
	

//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, password);
//	}
//
//	@Override
//	we override to know how to handle it behind the scenes
//	public boolean equals(Object obj) {
//		//this are the 5 points under equals contract
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Register other = (Register) obj;
//		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
//				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
//				&& Objects.equals(password, other.password);
//	}
	
	//private stuff will be accessible only within the class
	
	//setter function : is used to set the value for a particular field
	//getter function : to get/return the value of a specific field
	
}