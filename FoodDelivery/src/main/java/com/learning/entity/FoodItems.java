package com.learning.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "fooditems")

public class FoodItems implements Comparable<FoodItems>{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String foodId;
	
    @NotBlank
	private String foodName;
    
    @NotBlank
	private String foodCost;
//    
//    @NotBlank
//	private String foodType;
    
//  @NotBlank
	private String description;
    
    private String foodPic;

	@Override
	public int compareTo(FoodItems o) {
		// TODO Auto-generated method stub   
		return this.foodId.compareTo(o.getFoodId());
	}
	@ManyToMany
	@JoinTable(name = "food_foodtypes",joinColumns = @JoinColumn(name="foodId"),inverseJoinColumns = @JoinColumn(name="foodTypeId"))
	private Set<FoodType> foodTypes = new HashSet<>();

}