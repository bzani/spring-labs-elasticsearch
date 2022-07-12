package com.bdpz.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bdpz.entity.Product;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {

	List<Product> findByName(String name);

	List<Product> findByNameContaining(String name);

	List<Product> findByManufacturerAndCategory(String manufacturer, String category);

}