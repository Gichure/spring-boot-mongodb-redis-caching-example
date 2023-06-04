package com.pgichure.springsamples.caching.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "Product")
public class Product{

    @Id
    private Long id;

    @Indexed
    private String mkuCode;

    private String name;

    private String description;

}