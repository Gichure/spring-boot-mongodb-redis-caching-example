package com.pgichure.springsamples.caching.services;

import com.pgichure.springsamples.caching.dtos.ProductDto;
import com.java.util.List;


public interface ProductServiceI{

    ProductDto findByMkuCode(String code);

    ProductDto findById(Long id);

    Lict<ProductDto> findByAll();

    ProductDto update(Long id, ProductDto request);

    void delete(Long id);

    ProductDto save(Long id, ProductDto request);

}