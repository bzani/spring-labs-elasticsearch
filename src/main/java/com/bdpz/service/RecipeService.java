package com.bdpz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdpz.entity.Recipe;
import com.bdpz.repository.RecipeRepository;

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
