package com.bdpz.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bdpz.elastic.model.Recipe;

@Repository
public interface RecipeRepository extends ElasticsearchRepository<Recipe, String> {

}