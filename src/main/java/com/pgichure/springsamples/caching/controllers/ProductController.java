package com.pgichure.springsamples.caching.controllers;


import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import com.pgichure.springsamples.caching.dtos.ProductDto;
import com.pgichure.springsamples.caching.services.ProductServiceI;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController{

    private final ProductServiceI service;

    @PostMapping
    @ApiOperation(value = "Save a product", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully saved the record"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The server encountered an error")
    })
    public ProductDto save(@RequestBody ProductDto product)
    {
        return service.save(product);
    }


    @GetMapping(value  = "/{id}")
    @Cacheable (value = "product", key = "#id")
    @ApiOperation(value = "Fetch product using ID", response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the record"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The server encountered an error")
    })
    public ProductDto findById(@PathVariable Long id)
    {
        return  service.findById(id);
    }
    
    @GetMapping
    @ApiOperation(value = "Fetch products listing", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the records"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The record you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "The server encountered an error")
    })
    public List<ProductDto> findAll()
    {
        return  service.findByAll();
    }
}