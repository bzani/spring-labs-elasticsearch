package com.bdpz.elastic.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Setting(indexStoreType = "doc")
@Document(indexName = "recipes")
public class Recipe {

	@Id
	private String id;

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
	
	@Field(type = FieldType.Long, name = "register_time")
	private Long registerTime;

}