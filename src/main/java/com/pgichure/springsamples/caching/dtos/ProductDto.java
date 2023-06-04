package com.pgichure.springsamples.caching.dtos;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ProductDto{

    private Long id;

    private String code;

    private String name;

    private String description;

}