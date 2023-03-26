package io.mars.cereal.controller.specification;

import io.mars.cereal.model.Product;
import org.springframework.http.ResponseEntity;

public interface ProductEndpoint {

    public ResponseEntity<Product> findById(Long id);

    public ResponseEntity<Product> createProduct(String name, Double price, String companyName);
    public ResponseEntity<Product> updateProduct(Long id, String name, Double price, String companyName);

    public void deleteProduct(Long id);
}
