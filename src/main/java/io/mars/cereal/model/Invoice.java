package io.mars.cereal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Invoice {

    @Id
    @SequenceGenerator(name = "cuteSequence", sequenceName = "cuteSequence"
            , initialValue = 1, allocationSize = 27)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuteSequence")
    private Long id;

}
