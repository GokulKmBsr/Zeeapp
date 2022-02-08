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

import com.learning.entity.FoodItems;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.FoodItemsRepository;
import com.learning.service.FoodItemsService;


@RestController
@RequestMapping("/fooditem")
public class FoodItemsController {
	
	@Autowired
	FoodItemsService foodItemsService;
	
	//add record
	@PostMapping("/addFood")
	public ResponseEntity<?> addFood(@Valid @RequestBody FoodItems foodItems) throws AlreadyExistsException {
		
	
		FoodItems result = foodItemsService.addFoodItems(foodItems);
		return ResponseEntity.status(201).body(result);
		
		}
	
	//retrieve single record
	@GetMapping("/{foodId}")
	public ResponseEntity<?> getFoodById(@PathVariable("foodId") String foodId) throws IdNotFoundException{
		FoodItems result = foodItemsService.getFoodItemById(foodId);
		return ResponseEntity.ok(result);	
		
	}
	
	//retrieve all records
	@GetMapping("/all")
	public ResponseEntity<?> getAllFoodDetails(){
		Optional<List<FoodItems>> optional = foodItemsService.getAllFoodItemsDetails();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
	@DeleteMapping("/delete/{foodId}")
	public ResponseEntity<?> deleteFoodById(@PathVariable("foodId") String foodId) throws IdNotFoundException, SQLException
	{
		String result = foodItemsService.deleteFoodItemsById(foodId);
		Map<String, String> map = new HashMap<>();
		map.put("message", "food item deleted");
		return ResponseEntity.status(201).body(result);
	}
	
	@PutMapping("/update/{foodId}")
	public ResponseEntity<?> updateFood(@PathVariable("foodId") String foodId, @RequestBody FoodItems foodItems) throws IdNotFoundException
	{
		FoodItems result = foodItemsService.updateFoodItems(foodId, foodItems);
		return ResponseEntity.status(201).body(result);
	}
	
}