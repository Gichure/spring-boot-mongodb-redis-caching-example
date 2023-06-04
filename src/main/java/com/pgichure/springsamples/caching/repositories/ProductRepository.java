package com.pgichure.springsamples.caching.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pgichure.springsamples.caching.models.Product;

public interface ProductRepository extends MongoRepository<Product, Long>{

    Product findByMkuCode(String code);

}