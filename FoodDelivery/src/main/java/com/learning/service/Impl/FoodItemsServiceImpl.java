package com.learning.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.FoodItems;
import com.learning.entity.User;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.FoodItemsRepository;
import com.learning.repo.FoodTypeRepository;
import com.learning.service.FoodItemsService;

@Service
public class FoodItemsServiceImpl implements FoodItemsService {

	@Autowired
	FoodItemsRepository foodRepository;
	
	@Autowired
	FoodTypeRepository foodTypeRepository;
	
	@Override
	public FoodItems addFoodItems(FoodItems foodItems) throws AlreadyExistsException {
		
		if(foodRepository.existsByFoodNameAndFoodCost(foodItems.getFoodName(), foodItems.getFoodCost()) == true) {
			throw new AlreadyExistsException("this record already exists");
		}
		FoodItems foods = foodRepository.save(foodItems);
		
		if(foods!=null) {
			return foods;
		}
		return null;
		

	}

	@Override
	public FoodItems updateFoodItems(String foodId, FoodItems foodItems) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(!this.foodRepository.existsById(foodId))
			throw new IdNotFoundException("Sorry food not found");
		
		return foodRepository.save(foodItems);
	}

	@Override
	public FoodItems getFoodItemById(String foodId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<FoodItems> optional =  foodRepository.findById(foodId);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("Sorry food not found");
		}
		else {
			return optional.get();
		}
	}

	@Override
	public FoodItems[] getAllFoodItems(){
		// TODO Auto-generated method stub
		List<FoodItems> list = foodRepository.findAll();
		FoodItems[] array = new FoodItems[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteFoodItemsById(String foodId) throws IdNotFoundException {
		// TODO Auto-generated method stub
		FoodItems optional;
		try {
			optional = this.getFoodItemById(foodId);
			if(optional==null) {
				throw new IdNotFoundException("Sorry food not found");
			}
			else {
				foodRepository.deleteById(foodId);
				return "food item deleted";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public Optional<List<FoodItems>> getAllFoodItemsDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(foodRepository.findAll());
	}
	
	

}
