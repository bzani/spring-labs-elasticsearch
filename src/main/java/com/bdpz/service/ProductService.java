package com.bdpz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

import com.bdpz.entity.Product;
import com.bdpz.repository.ProductRepository;

@Service
public class ProductService {

	private static final String PRODUCT_INDEX = "products";

	@Autowired
	private ElasticsearchOperations elasticsearchOperations;

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		Iterable<Product> iProducts = productRepository.findAll();
		iProducts.forEach(p -> products.add(p));
		return products;
	}

	public void createProductIndexBulk(final List<Product> products) {

		List<IndexQuery> queries = products.stream()
				.map(product -> new IndexQueryBuilder().withId(product.getId().toString()).withObject(product).build())
				.collect(Collectors.toList());

		elasticsearchOperations.bulkIndex(queries, IndexCoordinates.of(PRODUCT_INDEX));
	}

	public String createProductIndex(Product product) {

		IndexQuery indexQuery = new IndexQueryBuilder().withId(product.getId().toString()).withObject(product).build();

		String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of(PRODUCT_INDEX));

		return documentId;
	}

//	public void findProductsByBrand(final String brandName) {
//
//		MatchQuery queryBuilder = QueryBuilders.matchQuery("manufacturer", brandName, null, null);
//		QueryBuilder queryBuildera = queryBuilder.;
//
//		Query searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder).build();
//
//		SearchHits<Product> productHits = elasticsearchOperations.search(searchQuery, Product.class,
//				IndexCoordinates.of(PRODUCT_INDEX));
//	}

	public void findByProductName(final String productName) {
		Query searchQuery = new StringQuery("{\"match\":{\"name\":{\"query\":\"" + productName + "\"}}}\"");

		SearchHits<Product> products = elasticsearchOperations.search(searchQuery, Product.class,
				IndexCoordinates.of(PRODUCT_INDEX));
		
		System.out.println(products);
	}

	public void findByProductPrice(final String productPrice) {
		Criteria criteria = new Criteria("price").greaterThan(10.0).lessThan(100.0);

		Query searchQuery = new CriteriaQuery(criteria);

		SearchHits<Product> products = elasticsearchOperations.search(searchQuery, Product.class,
				IndexCoordinates.of(PRODUCT_INDEX));
		
		System.out.println(products);
	}
	
}
