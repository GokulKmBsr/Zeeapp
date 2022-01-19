package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.repository.impl.UserRepositoryimpl;
import com.zee.zee5app.service.UserService;

public class UserServiceimpl implements UserService {
	
	private UserRepository userrepository = UserRepositoryimpl.getInstance();

	public UserServiceimpl() {
		
	}
	
	private static UserService service;
	
	public static UserService getInstance() {
		if(service==null) {
			service = new UserServiceimpl();
		}
		return service;
	}
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Register getUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
