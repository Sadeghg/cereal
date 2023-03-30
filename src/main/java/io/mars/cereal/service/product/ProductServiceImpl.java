package io.mars.cereal.service.product;

import io.mars.cereal.data.product.ProductRepository;
import io.mars.cereal.model.Product;
import io.mars.cereal.model.exception.ContentNotFound;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product)
                .orElseThrow(() -> new ContentNotFound("no such product found"));
    }
}
