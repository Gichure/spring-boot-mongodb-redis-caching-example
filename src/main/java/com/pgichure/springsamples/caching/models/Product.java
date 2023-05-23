package com.pgichure.springsamples.caching.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;

@Data
@Entity 
@Table(name = "products") 
public class Product{

    @Id
    private Long id;

    @Indexed
    @Column(name = "code", nullable = false)
    private String mkuCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

}