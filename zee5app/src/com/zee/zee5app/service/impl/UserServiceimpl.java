//package com.zee.zee5app.service.impl;
//
//import java.util.Optional;
//
//import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.repository.impl.UserRepositoryimpl;
//import com.zee.zee5app.service.UserService;
//
//public class UserServiceimpl implements UserService {
//	
//	private UserRepository userrepository = UserRepositoryimpl.getInstance();
//
//	public UserServiceimpl() {
//		
//	}
//	
//	private static UserService service;
//	
//	public static UserService getInstance() {
//		if(service==null) {
//			service = new UserServiceimpl();
//		}
//		return service;
//	}
//	@Override
//	public String addUser(Register register) {
//		// TODO Auto-generated method stub
//		return userRepository.addUser(register);
//	}
//
//	@Override
//	public String updateUser(String id, Register register) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Register> getUserById(String id) {
//		// TODO Auto-generated method stub
//		return UserRepository.getUserById(id);
//	}
//
//	@Override
//	public Register[] getAllUsers() {
//		// TODO Auto-generated method stub
//		return userrepository.getAllUsers();
//	}
//
//	@Override
//	public String deleteUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}

package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.UserService;

public class UserServiceimpl implements UserService {
	
	private UserServiceimpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserService service;
	
	public static UserService getInstance() {
		
		if(service==null) {
			service = new UserServiceimpl();
		}
		
		return service;
	}
	
	//UserRepository userRepository ;

	UserRepository userRepository  =  UserRepositoryimpl.getInstance();
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		return userRepository.deleteUserById(id);
	}

	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
		return userRepository.getAllUserDetails();
	}

}
