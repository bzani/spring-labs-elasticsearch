package com.bdpz.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setting(indexStoreType = "recipe")
@Document(indexName = "recipes")
public class Recipe {

	@Id
	private String id;

//	@Field(type = FieldType.Text, name = "name")
//	private String name;
//
//	@Field(type = FieldType.Double, name = "price")
//	private Double price;
//
//	@Field(type = FieldType.Integer, name = "quantity")
//	private Integer quantity;
//
//	@Field(type = FieldType.Keyword, name = "category")
//	private String category;
//
//	@Field(type = FieldType.Text, name = "desc")
//	private String description;
//
//	@Field(type = FieldType.Keyword, name = "manufacturer")
//	private String manufacturer;
	
	@Field(type = FieldType.Double, name = "cooking_time_min")
	private Double cookingTimeMin;
	
	@Field(type = FieldType.Double, name = "preparation_time_min")
	private Double preparationTimeMin;
	
	@Field(type = FieldType.Integer, name = "serves")
	private Integer serves;
	
	@Field(type = FieldType.Nested, name = "keywords")
	private List<String> keywords;
	
	@Field(type = FieldType.Double, name = "rating_score")
	private Double ratingScore;
	
	@Field(type = FieldType.Nested, name = "nutrition_information")
	private List<NutritionInfo> nutritionInformation;
	
	@Field(type = FieldType.Nested, name = "ingredients")
	private List<Ingredient> ingredients;
	
	@Field(type = FieldType.Nested, name = "courses")
	private List<String> courses;
	
	@Field(type = FieldType.Nested, name = "cusines")
	private List<String> cusines;
	
	@Field(type = FieldType.Integer, name = "skill_level")
	private Integer skillLevel;
	
	@Field(type = FieldType.Date, name = "register_time")
	private Date registerTime;

}