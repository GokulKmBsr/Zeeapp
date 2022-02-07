package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private LoginService service;
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
	public Register addUser(Register register) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		//make exception for the next line
		boolean status = repository.existsByEmailAndContactnumber(register.getEmail(), register.getContactnumber()) ;
		if(status) {
			throw new AlreadyExistsException("this record already exists");
		}
		Register register2 = repository.save(register);
		if (register2 != null) {
			Login login = new Login(register.getEmail(), register.getPassword(),register2);
			if(loginRepository.existsByuserName(register.getEmail())) {
				throw new AlreadyExistsException("this record already exists");
			}
			String result = service.addCredentials(login);
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
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
		//we dont write here coz update is automatically taken care of
	}

	@Override
	public Register getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional =  repository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id does not exists");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public Register[] getAllUsers()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<Register> list = repository.findAll();
		Register[] array = new Register[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//cross check with findbyid
		//use optional here coz findbyid return optional type

			Register optional;
			try {
				optional = this.getUserById(id);
				if(optional==null) {
					throw new IdNotFoundException("record not found");
				}
				else {
					repository.deleteById(id);
					return "register record deleted";
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
		return Optional.ofNullable(repository.findAll());
	}

}

//package com.zee.zee5app.service.impl;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//import org.apache.catalina.startup.ClassLoaderFactory.Repository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.zee.zee5app.dto.Role;
//import com.zee.zee5app.dto.Login;
//import com.zee.zee5app.dto.EROLE;
//import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.exception.AlreadyExistsException;
//import com.zee.zee5app.exception.IdNotFoundException;
//import com.zee.zee5app.exception.InvalidEmailException;
//import com.zee.zee5app.exception.InvalidIdLengthException;
//import com.zee.zee5app.exception.InvalidNameException;
//import com.zee.zee5app.exception.InvalidPasswordException;
//import com.zee.zee5app.repository.LoginRepository;
//import com.zee.zee5app.repository.UserRepository;
//import com.zee.zee5app.service.LoginService;
////import com.zee.zee5app.repository.impl.UserRepositoryImpl;
//import com.zee.zee5app.service.UserService;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	//Login Service
//	@Autowired
//	private LoginService loginService;
//	//private LoginServiceImpl loginService; //we need to use login service instead of loginserviceimpl,but both will work
//	
//	@Autowired
//	private LoginRepository loginRepository;
////	private UserServiceImpl() throws IOException {
////		
////	}
////	
////	private static UserService service;
////	public static UserService getInstance() throws IOException{
////		if(service==null)
////			service = new UserServiceImpl();
////		return service;
////	}
//	
//	@Override
//	@org.springframework.transaction.annotation.Transactional(rollbackFor = AlreadyExistsException.class)
//	
//	public Register addUser(Register register) throws AlreadyExistsException {
//		// TODO Auto-generated method stub
//		
//		//return this.repository.addUser(register);
//		//userRepository.findById(register.getId());
//		if(userRepository.existsByEmailAndContactnumber(register.getEmail(), register.getContactnumber()) == true) {
//			throw new AlreadyExistsException("this record already exists");
//			//NullPointerException("!!! null pointer exists !!!");
//		}
//		Register register2 = userRepository.save(register);
//		if (register2 != null) {
////			Login login = new Login(register.getEmail(), register.getPassword(), register.getRegid());
////			String result = loginService.addCredentials(login);
////			if(result.equals( "success")) {
////				return "record is sucessfully added to register as well as login";
////			}
////			else {
////				return "fail";
////			}
//			return register2;
//		}
//		else {
//			return null;
//		}
//	}
//
//
//@Override
//public String updateUser(String id, Register register) throws IdNotFoundException {
//	// TODO Auto-generated method stub
//	
//	return null;
//}
//
//@Override
//public Register getUserById(String id) throws IdNotFoundException{
//	// TODO Auto-generated method stub
//	//return userRepository.findById(id);
//	//return null;
//	Optional<Register> optional= userRepository.findById(id);
//	if(optional.isEmpty()) {
//		throw new IdNotFoundException("id doesnot exists");
//	}
//	else {
//		return optional.get();
//	}
//}
//
//@Override
//public Register[] getAllUsers()
//		throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//	// TODO Auto-generated method stub
//	
//	List<Register> list = userRepository.findAll();
//	Register[] array=new Register[list.size()];
//	return list.toArray(array);
//}
//
//@Override
//public String deleteUserById(String id) throws IdNotFoundException {
//	// TODO Auto-generated method stub
//	//can we cross checkit with findById() =>gives record exists
//	Register optional;
//	try {
//		optional = this.getUserById(id);
//		if(optional==null) {
//			throw new IdNotFoundException("record not found");
//		}
//		else {
//			userRepository.deleteById(id);
//			return "success deleting";
//		}
//	} catch (IdNotFoundException  e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		throw new IdNotFoundException(e.getMessage());
//	}
//			
//	//userRepository.deleteById(id);
//	//return null;
//}
//
//@Override
//public Optional<List<Register>> getAllUserDetails(){
//	// TODO Auto-generated method stub
//	return Optional.ofNullable(userRepository.findAll());
//	//return null;
//}
//
////	@Override
////	public String updateUser(String id, Register register) throws IdNotFoundException {
////		// TODO Auto-generated method stub
////		return this.repository.updateUser(id, register);
////	}
////
////	@Override
////	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidEmailException, InvalidPasswordException, InvalidNameException {
////		// TODO Auto-generated method stub
////		return this.repository.getUserById(id);
////	}
////
////	@Override
////	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
////		// TODO Auto-generated method stub
////		return this.repository.getAllUsers();
////	}
////
////	@Override
////	public String deleteUserById(String id) throws IdNotFoundException {
////		// TODO Auto-generated method stub
////		return this.repository.deleteUserById(id);
////	}
////	@Override
////	public Optional<List<Register>> getAllUserDetails() throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
////		// TODO Auto-generated method stub
////		return this.repository.getAllUserDetails();
////	}
////	
//	
//
//}