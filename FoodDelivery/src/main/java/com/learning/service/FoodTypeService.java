package com.learning.service;

import java.util.Optional;

import com.learning.entity.FoodType;
import com.learning.exception.IdNotFoundException;

public interface FoodTypeService {

	public String addFoodType(FoodType foodType);
	public void deleteFoodTypeById(int foodTypeId) throws IdNotFoundException;
	public Optional<FoodType> getFoodTypeById(int foodTypeId);
}