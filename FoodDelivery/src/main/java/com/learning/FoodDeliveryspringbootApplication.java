package com.learning;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.learning.entity.EFOODTYPE;
import com.learning.entity.FoodType;
import com.learning.exception.AlreadyExistsException;
import com.learning.repo.FoodTypeRepository;
import com.learning.service.FoodTypeService;

@SpringBootApplication
public class FoodDeliveryspringbootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext applicationContext =	SpringApplication.run(FoodDeliveryspringbootApplication.class, args);

//		FoodTypeService foodTypeService = applicationContext.getBean(FoodTypeService.class);
//        FoodTypeRepository foodTypeRepository = applicationContext.getBean(FoodTypeRepository.class);
//		
//		FoodType foodType = new FoodType();
//		foodType.setFoodType(EFOODTYPE.Chinese);
//		FoodType foodType2 = new FoodType();
//		foodType2.setFoodType(EFOODTYPE.Indian);
//		FoodType foodType3 = new FoodType();
//		foodType3.setFoodType(EFOODTYPE.Mexican);
//		foodTypeService.addFoodType(foodType2);
//		foodTypeService.addFoodType(foodType);
//		foodTypeService.addFoodType(foodType3);
//		Set<FoodType> foodtype = new HashSet<>();

		
		
		//applicationContext.close();
	}

}
