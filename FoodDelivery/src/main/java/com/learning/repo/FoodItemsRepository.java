package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.FoodItems;

@Repository
public interface FoodItemsRepository extends JpaRepository<FoodItems, String> {

	Boolean existsByFoodNameAndFoodCost(String foodName,  String foodCost);
	
}
