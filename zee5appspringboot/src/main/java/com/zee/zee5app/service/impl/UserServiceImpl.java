package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
//	private UserServiceImpl() throws IOException {
//		
//	}
//	
//	private static UserService service;
//	public static UserService getInstance() throws IOException{
//		if(service==null)
//			service = new UserServiceImpl();
//		return service;
//	}
	
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		
		//return this.repository.addUser(register);
		Register register2 = userRepository.save(register);
		if(register2!=null) {
			return "Successfully added user";
		}
		else {
			return "failed to add user";
		}
	}

@Override
public String updateUser(String id, Register register) throws IdNotFoundException {
	// TODO Auto-generated method stub
	
	return null;
}

@Override
public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException,
		InvalidEmailException, InvalidPasswordException, InvalidNameException {
	// TODO Auto-generated method stub
	return userRepository.findById(id);
	//return null;
}

@Override
public Register[] getAllUsers()
		throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
	// TODO Auto-generated method stub
	
	List<Register> list = userRepository.findAll();
	Register[] array=new Register[list.size()];
	return list.toArray(array);
}

@Override
public String deleteUserById(String id) throws IdNotFoundException {
	// TODO Auto-generated method stub
	//can we cross checkit with findById() =>gives record exists
	
	try {
		Optional<Register> optional = this.getUserById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			userRepository.deleteById(id);
			return "success deleting";
		}
	} catch (IdNotFoundException | InvalidIdLengthException | InvalidEmailException | InvalidPasswordException
			| InvalidNameException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new IdNotFoundException(e.getMessage());
	}
			
	//userRepository.deleteById(id);
	//return null;
}

@Override
public Optional<List<Register>> getAllUserDetails()
		throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
	// TODO Auto-generated method stub
	return Optional.ofNullable(userRepository.findAll());
	//return null;
}

//	@Override
//	public String updateUser(String id, Register register) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return this.repository.updateUser(id, register);
//	}
//
//	@Override
//	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException, InvalidNameException {
//		// TODO Auto-generated method stub
//		return this.repository.getUserById(id);
//	}
//
//	@Override
//	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		// TODO Auto-generated method stub
//		return this.repository.getAllUsers();
//	}
//
//	@Override
//	public String deleteUserById(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		return this.repository.deleteUserById(id);
//	}
//	@Override
//	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		// TODO Auto-generated method stub
//		return this.repository.getAllUserDetails();
//	}
//	
	

}