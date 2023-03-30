package io.mars.cereal.data.product;


import io.mars.cereal.model.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> save(Product product);

    Collection<Product> saveAll(Collection<Product> products);

    Collection<Product> saveAll(Product... products);
    Optional<Product> findById(Long id);

    void deleteById(Long id);


}
