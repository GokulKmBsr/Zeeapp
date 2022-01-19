package com.zee.zee5app.dto;
import lombok.Data;
@Data
public class Register {
	private String id;
	private String firstName;
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
	

}
