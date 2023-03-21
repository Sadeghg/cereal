package io.mars.cereal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CardItem {

    @Id
    @SequenceGenerator(name="cuteSequence", sequenceName = "cuteSequence"
            , initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "card_id", foreignKey = @ForeignKey(name = "card_fk_id"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Card card;

    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "product_fk_id"))
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
}
