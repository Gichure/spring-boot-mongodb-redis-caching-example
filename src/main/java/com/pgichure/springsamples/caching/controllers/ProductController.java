package com.pgichure.springsamples.caching.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgumentsContructor
@RequestMapping(value = "/products")
public interface ProductController{

    private final ProductServiceI service;

    @Autowired
    MongoTemplate mongoTemplate;

    @POST
    public ProductDto save(ProductDto product)
    {
        return repository.save(product);
    }


    @Get(value "/{id}")
    @Cacheable (value = "product", key = "#id")
    public ProductDto findById(@PathVariable Long id)
    {
        ProductDto product = repository.findById(id);
        return product;
    }
}