package com.bdpz.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdpz.entity.Recipe;
import com.bdpz.service.RecipeService;

@RequestMapping("/api/v1")
@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("/recipes")
	public ResponseEntity<List<Recipe>> getAll() {
		return ResponseEntity.ok(recipeService.findAll()); 
	}
	
	@PostMapping("/recipes")
	public ResponseEntity<URI> save(@RequestBody Recipe recipe) throws URISyntaxException {
		URI uri = new URI(recipeService.save(recipe).getId());
		return ResponseEntity.created(uri).build();
		 
	}
	
}
