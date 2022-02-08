package com.learning.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Login;
import com.learning.entity.Register;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.LoginRepository;
import com.learning.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login login2 = loginRepository.save(login);
		if (login2 != null) {
			return "success";
		} else {
			return "fail";
		}
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
				return "login record deleted";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String changePassword(String userName, String password) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Login> login = this.loginRepository.findById(userName);
		if(login.isEmpty())
			throw new IdNotFoundException("invalid id");
		login.get().setPassword(password);
		return (this.loginRepository.save(login.get())!= null) ? "success":"fail";
	}


}
