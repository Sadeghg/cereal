package io.mars.cereal.controller.specification;

import io.mars.cereal.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductEndpoint {

    public ResponseEntity<Product> findById(Long id);

}
