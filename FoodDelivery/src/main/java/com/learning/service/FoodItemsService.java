package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.entity.FoodItems;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

public interface FoodItemsService {

	public FoodItems addFoodItems(FoodItems foodItems) throws AlreadyExistsException;
	public FoodItems updateFoodItems(String foodId, FoodItems foodItems) throws IdNotFoundException;
	public FoodItems getFoodItemById(String foodId) throws IdNotFoundException;
	public FoodItems[] getAllFoodItems();
	public String deleteFoodItemsById(String foodId) throws IdNotFoundException;
	public Optional<List<FoodItems>> getAllFoodItemsDetails();
}