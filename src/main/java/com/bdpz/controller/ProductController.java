package com.bdpz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdpz.entity.Recipe;
import com.bdpz.service.ProductService;

@RequestMapping("/api/v1")
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Recipe>> getAll() {
		return ResponseEntity.ok(productService.findAll()); 
	}
	
}
