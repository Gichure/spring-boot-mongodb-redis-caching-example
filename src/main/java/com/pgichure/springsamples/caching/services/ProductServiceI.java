package com.pgichure.springsamples.caching.services;

import java.util.List;

import com.pgichure.springsamples.caching.dtos.ProductDto;
import com.pgichure.springsamples.caching.models.Product;


public interface ProductServiceI{

    public ProductDto findByMkuCode(String code);

    public ProductDto findById(Long id);

    public List<ProductDto> findByAll();

    public ProductDto update(Long id, ProductDto request);

    public void delete(Long id);

    public ProductDto save(ProductDto request);

}