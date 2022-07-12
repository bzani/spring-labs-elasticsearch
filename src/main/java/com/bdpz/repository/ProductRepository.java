package com.bdpz.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bdpz.entity.Recipe;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Recipe, String> {

	List<Recipe> findByName(String name);

	List<Recipe> findByNameContaining(String name);

	List<Recipe> findByManufacturerAndCategory(String manufacturer, String category);

}