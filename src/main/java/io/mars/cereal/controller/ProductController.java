package io.mars.cereal.controller;

import io.mars.cereal.controller.specification.ProductEndpoint;
import io.mars.cereal.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController implements ProductEndpoint {

    @Override
    public ResponseEntity<Product> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> createProduct(String name, Double price, String companyName) {
        return null;
    }
}
