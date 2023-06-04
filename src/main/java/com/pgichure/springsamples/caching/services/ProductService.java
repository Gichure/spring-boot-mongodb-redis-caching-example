package com.pgichure.springsamples.caching.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pgichure.springsamples.caching.dtos.ProductDto;
import com.pgichure.springsamples.caching.models.Product;
import com.pgichure.springsamples.caching.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class ProductService implements ProductServiceI{

    private final ProductRepository repository;

    @Override
	public ProductDto findByMkuCode(String code){
    	Product product = repository.findByMkuCode(code);
    	
        return this.getDto(product);

    }

    @Override
	public ProductDto findById(Long id){
    	Optional<Product> product = repository.findById(id);
        return product.isPresent() ? this.getDto(product.get()) : null;
    }

    @Override
	public List<ProductDto> findByAll(){
    	List<Product> products = repository.findAll();
    	
    	return products.stream()
                .map(p -> this.getDto(p))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto update(Long id, ProductDto request){
    	Optional<Product> product = repository.findById(id);
    	if(product.isPresent()) {
    		request.setId(id);
    		Product updatedProduct = this.getProduct(request);
    		updatedProduct = repository.save(updatedProduct);
    		
    		return this.getDto(updatedProduct);
    	}
    	
    	return null;
    }
    
    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public ProductDto save(ProductDto request){
    	Product product = this.getProduct(request);
    	product = repository.save(product);
    	return this.getDto(product);
    	
    }
    
    
    private Product getProduct(ProductDto dto) {
    	return Product.builder()
    			.description(dto.getDescription())
    			.id(dto.getId())
    			.mkuCode(dto.getCode())
    			.name(dto.getName())
    			.build();
    }

    private ProductDto getDto(Product product) {
    	return ProductDto.builder()
    			.description(product.getDescription())
    			.id(product.getId())
    			.code(product.getMkuCode())
    			.name(product.getName())
    			.build();
    }
    
}