package com.bdpz.elastic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdpz.elastic.model.Recipe;
import com.bdpz.elastic.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	public List<Recipe> findAll() {
		List<Recipe> recipes = new ArrayList<>();
		recipeRepository.findAll().forEach(p -> recipes.add(p));
		return recipes;
	}
	
	public Recipe findById(String id) {
		return recipeRepository.findById(id).get();
	}

	public Recipe save(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
}
