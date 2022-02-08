package com.learning.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Login;
import com.learning.entity.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.UserRepository;
import com.learning.service.LoginService;
import com.learning.service.UserService;

import lombok.val;

@RestController //combination of @ResponseBody and @Controller
//REST API: Response wherever we have to share the response that method must be marked with @ResponseBody
//1000 methods ---> @ResponseBody 1000 times so o avoid this we use @RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginService loginService;
	
	@PostMapping("/addUser")
	//used ? so we can return any type
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {
		
		//1. It should store the received info in database
		Register result = userService.addUser(register);
		return ResponseEntity.status(201).body(result);
		
		}
	//retrieve single record
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
		Register result = userService.getUserById(id);
		return ResponseEntity.ok(result);	
		
	}
	
	//retrieve all records
	@GetMapping("/all")
	public ResponseEntity<?> getAllUserDetails(){
		Optional<List<Register>> optional = userService.getAllUserDetails();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") String id) throws IdNotFoundException, SQLException
	{
		String result = userService.deleteUserById(id);
		Map<String, String> map = new HashMap<>();
		map.put("message", "User deleted successfully");
		return ResponseEntity.status(201).body(result);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody Register register) throws IdNotFoundException
	{
		Register result = userService.updateUser(id, register);
		return ResponseEntity.status(201).body(result);
	}
	
	@PostMapping(path = "/authenticate")
	public ResponseEntity<?> authenticateUser(@RequestBody Register register) {
		HashMap<String, String> resp = new HashMap<>();
		resp.put("message", userService.authenticateUser(register));

		if (resp.get("message").equals("success"))
			return ResponseEntity.status(200).body(resp);
		return ResponseEntity.status(403).body(resp);

	}


}