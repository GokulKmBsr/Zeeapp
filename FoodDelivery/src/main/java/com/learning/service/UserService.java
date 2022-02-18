package com.learning.service;

import java.util.Optional;

import com.learning.entity.User;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import java.util.List;


public interface UserService {
	public User addUser(User register) throws AlreadyExistsException;
	public User updateUser(Long id, User register) throws IdNotFoundException;
	public User getUserById(Long id) throws IdNotFoundException;
	public User[] getAllUsers() ;
	public String deleteUserById(Long id) throws IdNotFoundException;
	public Optional<List<User>> getAllUserDetails();
	public String authenticateUser(User register);
}