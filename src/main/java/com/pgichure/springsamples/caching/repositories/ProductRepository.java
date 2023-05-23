package com.pgichure.springsamples.caching.repositories;

import com.pgichure.springsamples.caching.models.Product;

public interface ProductRepository extends MongoRepository <Product, Long>{

    Product findByMkuCode(String code);

}