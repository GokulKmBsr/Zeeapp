package com.learning.service;

import java.util.Optional;

import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import java.util.List;


public interface UserService {
	public Register addUser(Register register) throws AlreadyExistsException;
	public Register updateUser(String id, Register register) throws IdNotFoundException;
	public Register getUserById(String id) throws IdNotFoundException;
	public Register[] getAllUsers() ;
	public String deleteUserById(String id) throws IdNotFoundException;
	public Optional<List<Register>> getAllUserDetails();
	public String authenticateUser(Register register);
}