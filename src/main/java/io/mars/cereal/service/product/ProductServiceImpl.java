package io.mars.cereal.service.product;

import io.mars.cereal.data.product.ProductRepository;
import io.mars.cereal.model.Product;
import io.mars.cereal.model.exception.ContentNotFound;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product)
                .orElseThrow(() -> new ContentNotFound("no such product found"));
    }

    @Override
    public Collection<Product> saveAll(Collection<Product> products) {
        return repository.saveAll(products);
    }

    @Override
    public Collection<Product> saveAll(Product... t) {
        return repository.saveAll(t);
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ContentNotFound("no such product found"));
    }

    @Override
    public Collection<Product> findAll(Collection<Long> ids) {
        return repository.findAll(ids);
    }
}
