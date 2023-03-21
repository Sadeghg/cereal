package io.mars.cereal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Company {

    @Id
    @SequenceGenerator(name = "cuteSequence", sequenceName = "cuteSequence"
            , initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
