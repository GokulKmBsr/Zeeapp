package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.LoginRepository;

//import com.zee.zee5app.repository.impl.LoginRepositoryImpl;
import com.zee.zee5app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
	private LoginRepository loginRepository  ;

	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		if(login2!=null) {
			return "Successfully added login details";
		}
		else {
			return "failed to add login details";
		}
		//return null;
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		Optional<Login> optional;
		try {
			optional = loginRepository.findById(userName);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				loginRepository.deleteById(userName);
				return "login details deleted";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		//return null;
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String userName, Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private LoginServiceImpl() throws IOException {
//		
//	}
//	
//	private static LoginService service;
//	public static LoginService getInstance() throws IOException{
//		if(service==null)
//			service = new LoginServiceImpl();
//		return service;
//	}
	
//	@Override
//	public String addCredentials(Login login) {
//		// TODO Auto-generated method stub
//		return repository.addCredentials(login);
//	}
//
//	@Override
//	public String deleteCredentials(String userName) {
//		// TODO Auto-generated method stub
//		return repository.deleteCredentials(userName);
//	}
//
//	@Override
//	public String changePassword(String userName, String password) {
//		// TODO Auto-generated method stub
//		return repository.changePassword(userName, password);
//	}
//
//	@Override
//	public String changeRole(String userName, ROLE role) {
//		// TODO Auto-generated method stub
//		return repository.changeRole(userName, role);
//	}

}