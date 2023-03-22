package io.mars.cereal.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Invoice {

    @Id
    @SequenceGenerator(name = "cuteSequence", sequenceName = "cuteSequence"
            , initialValue = 1, allocationSize = 27)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuteSequence")
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "invoice_item_list",
            uniqueConstraints = @UniqueConstraint(name = "invoice_item_key", columnNames = {"invoice_item_id"}),
            joinColumns = {@JoinColumn(
                    name = "invoice_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "invoice_fk"))},
            inverseJoinColumns = {@JoinColumn(
                    name = "invoice_item_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "invoice_item_fk")
            )})
    private List<CardItem> invoiceItemList;

}
