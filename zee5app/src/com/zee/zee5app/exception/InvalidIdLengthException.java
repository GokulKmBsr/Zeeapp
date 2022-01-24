package com.zee.zee5app.exception;

import lombok.ToString;

@ToString(callSuper = true)
//toString from base class
//this is lombok method for this below commented one 
//public String toString() {
//return "IdNotFoundException [toString()=" + super.toString() + "]";
//}


public class InvalidIdLengthException extends Exception {
	//as an user defined Exception

	public InvalidIdLengthException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IdNotFoundException [toString()=" + super.toString() + "]";
	}
	
	
	

}
