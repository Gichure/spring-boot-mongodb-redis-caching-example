package com.pgichure.springsamples.caching.services;

import com.pgichure.springsamples.caching.repositories.ProductRepository;
import com.pgichure.springsamples.caching.models.ProductDto;

@Service 
@RequiredArgumentsContructor
public class ProductService implements ProductServiceI{

    private final ProductRepository repository;


    ProductDto findByMkuCode(String code){
        return repository.findByMkuCode(code);

    }

    ProductDto findById(Long id){
        return repository.findById(id);
    }

    Lict<ProductDto> findByAll(){

    }

    ProductDto update(Long id, ProductDto request){

    }

    void delete(Long id){
        repository.deleteById(id);
    }

    ProductDto save(Long id, ProductDto request){

    }


}