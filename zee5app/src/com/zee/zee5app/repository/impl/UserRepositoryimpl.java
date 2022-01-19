package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserRepositoryimpl implements UserRepository {

	private Register[] registers = new Register[10];
	private static int count=-1;
	
	//do we need singleton object for Repository? yes
	public UserRepositoryimpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	
	public static UserRepository getInstance() {
		if (repository == null) {
			repository = new UserRepositoryimpl();
		}
		return repository;
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		if(count==registers.length-1) {
			// array is full or we should go for dynamically growing the 
			// size of array.
			Register temp[] = new Register[registers.length*2];
			
			// do we need to copy the contents from old to new? Yes
			
			System.arraycopy(registers, 0, temp, 0, registers.length);
			registers= temp;
			registers[++count] = register;
			
			
			return "success";
			
		}
		registers[++count] = register;
		return "success";
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
		return registers;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
