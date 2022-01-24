package com.zee.zee5app.exception;

import lombok.ToString;

@ToString

public class IdNotFoundException extends Exception {
	public IdNotFoundException (String message) {
		super(message);
	}

}
