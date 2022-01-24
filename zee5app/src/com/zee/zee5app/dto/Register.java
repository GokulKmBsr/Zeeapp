package com.zee.zee5app.dto;
import java.util.Objects;

import javax.naming.InvalidNameException;

import com.zee.zee5app.exception.InvalidIdLengthException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
//@Data
@Setter
@Getter
//@EqualsAndHashCode
public class Register{ //implements Comparable<Register> {
	
	

	public Register(String id, String firstname, String lastname, String email, String password) throws InvalidIdLengthException, InvalidNameException {
		super();
		this.setId(id);
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.email= email;
		this.password=password;
	}
	
	@Setter(value = AccessLevel.NONE)
	private String id;
	//it should have min length of 6
	//we have to write
	
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	private String email;
	private String password;
	//private stuff will be accessible only inside the class
	//setter : is used to set the values for a particular field.
	//getter : to get/return the value of a specific field
	public Register() {
		//EDC
		System.out.println("hello");
	}
	
	public void setFirstName(String firstName) throws InvalidNameException {
		if(firstName==null || firstName=="" || firstName.length()<2) {
			throw new InvalidNameException("first name is not valid");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName==null || lastName=="" || lastName.length()<2) {
			throw new InvalidNameException("last name is not valid");
		}
		this.lastName = lastName;
	}
	
	public void setId(String id) throws InvalidIdLengthException {
		//throws :it will provide the 
		if(id.length()<6) {
			//it should raise the InvalidIdLengthException
			//exception object is created by JVM 
			//user defined exception object must be raised by us
			throw new InvalidIdLengthException("id length is lesser than or eq to 6");
		}
		this.id = id;
	}
	
	//the below two hascode and equals only for the single one ,if you want
	//to change any this ,that is too difficult.we need to change every time
	//that is why we will just use @Data or (@EqualsAndHashCode @Setter @Getter)
	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Register other = (Register) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password);
	}

//	@Override
//	public int compareTo(Register o) {
//		// TODO Auto-generated method stub
//		//return this.id.compareTo(o.getId()); //ascending order
//		return o.id.compareTo(this.getId());  //descending
//	}

}
