package io.mars.cereal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_name", columnDefinition = "TEXT")
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

}
