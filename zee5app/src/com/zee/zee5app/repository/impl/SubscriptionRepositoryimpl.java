//package com.zee.zee5app.repository.impl;
//
//import java.util.set;
//import java.util.Optional;
//
//import javax.naming.InvalidNameException;
//
//import com.zee.zee5app.dto.Register;
//import com.zee.zee5app.repository.UserRepository;
//
//public class UserRepositoryimpl implements UserRepository {
//
//	//private Register[] registers = new Register[10];
//	private set<Register> set = new set<>();
//	//private static int count=-1;
//	
//	//do we need singleton object for Repository? yes
//	public UserRepositoryimpl() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	private static UserRepository repository;
//	
//	public static UserRepository getInstance() {
//		if (repository == null) {
//			repository = new UserRepositoryimpl();
//		}
//		return repository;
//	}
//	
//	@Override
//	public String addUser(Register register) {
//		// TODO Auto-generated method stub
//		boolean result = this.set.add(register);
//		if(result) {
//			return "sucess";
//			
//		}
//		return "fail";
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
//		Register register2 = null;
//		for (Register register :set) {
//			if(register.getId().equals(id)) {
//				register2= register;
//			}
//		}
//		return Optional.ofNullable(register2);
//	}
//
//	@Override
//	public Register[] getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deleteUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}



package com.zee.zee5app.repository.impl;

//import java.util.set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository;

public class SubscriptionRepositoryimpl implements UserRepository {
	
	private TreeSet<Register> set = new TreeSet<>();
	//private List<Register> set = new LinkedList<>();
	//when u will use DC for set then by default it will hold 
	//10 elements of type register 
	
	//private set<Register> set = new set<>();
	// when u will use DC for AL then by default it will hold 10 elements
	// of type Register.
	
	//private static int count=-1;
	
	private SubscriptionRepositoryimpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserRepository repository;
	
	public static UserRepository getInstance() {
		if(repository==null) {
			repository = new SubscriptionRepositoryimpl();
		}
		return repository;
	}

	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		boolean result = this.set.add(register);
		System.out.println(this.set.size());
		
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		// do we need to traverse the AL?
		// yes 
		Register register2 = null;
		for (Register register : set) {
			if(register.getId().equals(id)) {
				register2= register;
				//break;
			}
		}
		return Optional.of(Optional.ofNullable(register2).orElseThrow(()->new IdNotFoundException("id not foud")));
		// if register2 is holding null it will act like an empty
		// if register2 is holding object it will act like of
		
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		//transfer the collection of array 
		Register register[] = new Register[set.size()];
		return set.toArray(register);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional= this.getUserById(id);
		if(optional.isPresent()) {
			//removal
			boolean result = set.remove(optional.get());
			if(result) {
				return "success";
			}
			else {
				return "fail";
			}
		}
//		else {
//			//throw idNotFoundException
//			//throw new IdNotFoundException("id not found exception");
//			return "fail";
//		}
		return "fail";
	}

	@Override
	public List<Register> getAllUserDetails() {
		// TODO Auto-generated method stub
		//Collections.sort(set);
		//return set;
		//to convert the set to list -> we can use set
		//set.descendingSet();
		return new ArrayList<>(set.descendingSet());
	}
	
}








	
// this is very old
	
//	@Override
//	public String addUser(Register register) {
//		// TODO Auto-generated method stub
//		if(count==registers.length-1) {
//			// array is full or we should go for dynamically growing the 
//			// size of array.
//			Register temp[] = new Register[registers.length*2];
//			
//			// do we need to copy the contents from old to new? Yes
//			
//			System.arraycopy(registers, 0, temp, 0, registers.length);
//			registers= temp;
//			registers[++count] = register;
//			
//			
//			return "success";
//			
//		}
//		registers[++count] = register;
//		return "success";
//	}
//
//	@Override
//	public String updateUser(String id, Register register) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Register getUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Register[] getAllUsers() {
//		// TODO Auto-generated method stub
//		return registers;
//	}
//
//	@Override
//	public String deleteUserById(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}



//}
