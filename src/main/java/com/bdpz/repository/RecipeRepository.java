package com.bdpz.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bdpz.entity.Recipe;

@Repository
public interface RecipeRepository extends ElasticsearchRepository<Recipe, String> {

}