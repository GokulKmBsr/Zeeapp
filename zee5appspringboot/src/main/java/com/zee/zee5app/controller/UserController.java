package com.zee.zee5app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;

@RestController //in version 4 //combination of @ResponseBody and @Controller
//REST API : RESPONSE whenever we have to share the response that method must be marked with @ResponseBody
//1000methods ->@ResponseBody -> 1000times ,so tthey made @Rest we will do everthing inside controller
//that is why it is @RestController
@RequestMapping("/api/users")
public class UserController {
	
	//responsible for adding the user to the table
	//info will be shared by the client in terms of json object
	//do we need to read that json object? -yes
	//where is this json object is available in request? ->requestbody
	//do we need to read that requestbody content? -yes
	//do we need to transform json object to java object ? ->yes -this thinh will taken care by => @RequestBody
	//
	
	//do we need to inform that when this method should be called?
	//for that we need to specify the end point
	@PostMapping("/addUser")
	public String addUser(@RequestBody Register register) {
		return register.toString();
	}

}
