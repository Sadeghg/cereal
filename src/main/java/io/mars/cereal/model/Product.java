package io.mars.cereal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Data
@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "cuteSequence", sequenceName = "cuteSequence"
            , initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "product_name", columnDefinition = "TEXT")
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "company_fk_id"), nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @ElementCollection
    @CollectionTable(name = "product_details",
            joinColumns = {@JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "product_details_fk"))
            })
    private Map<String, String> details;
}
