package io.mars.cereal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", columnDefinition = "TEXT")
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @ElementCollection
    @CollectionTable(name = "product_details",
            joinColumns = {@JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "product_details_fk"))
            })
    private Map<String, String> details;
}
