package com.learning.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Login;
import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.repo.UserRepository;
import com.learning.service.LoginService;
import com.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginService loginService;
	@Autowired
	private LoginRepository loginRepository;

	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		boolean status = userRepository.existsByEmail(register.getEmail()) ;
		if(status) {
			throw new AlreadyExistsException("this record already exists");
		}
		Register register2 = userRepository.save(register);
		if (register2 != null) {
			Login login = new Login(register.getEmail(), register.getPassword(),register2);
			if(loginRepository.existsByEmailAndPassword(register.getEmail(), register.getPassword())) {
				throw new AlreadyExistsException("this record already exists");
			}
			String result = loginService.addCredentials(login);
			if(result == "success") {
					//return "record added in register and login";
				return register2;
			}
			else {
				return null;
			}
		}	
		else {
			return null;
		}
	}

	@Override
	public Register updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		if(!this.userRepository.existsById(id))
			throw new IdNotFoundException("Sorry user with " + register.getId() + " not found");
		
		return userRepository.save(register);
	}

	@Override
	public Register getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register register = new Register();
		Optional<Register> optional =  userRepository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("Sorry user With " + register.getId() + " not found");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public Register[] getAllUsers() {
			// TODO Auto-generated method stub
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register optional;
		Register register = new Register();
		try {
			optional = this.getUserById(id);
			if(optional==null) {
				throw new IdNotFoundException("Sorry user With " + register.getId() + " not found");
			}
			else {
				userRepository.deleteById(id);
				return "User Deleted Successfully";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<Register>> getAllUserDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}
	
	@Override
	public String authenticateUser(Register register) {
		boolean exists = userRepository.existsByEmailAndPassword(register.getEmail(), register.getPassword());
		return exists ? "success" : "fail";

	}
	

}
