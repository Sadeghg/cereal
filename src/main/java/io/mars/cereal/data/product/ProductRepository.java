package io.mars.cereal.data.product;


import io.mars.cereal.model.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> save(Product product);

    Collection<Product> saveAll(Collection<Product> products);

    Collection<Product> saveAll(Product... products);
    Optional<Product> findById(Long id);

    Collection<Product> findAll(Collection<Long> ids);

    Collection<Product> findAll(Long... ids);

    void deleteById(Long id);

    void deleteAll(Collection<Long> ids);

    void deleteAll(Long... ids);

}
