package io.mars.cereal.controller;

import io.mars.cereal.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return null;
    }

    public ResponseEntity<Product> createProduct(String name, Double price, String companyName) {
        return null;
    }

    public ResponseEntity<Product> updateProduct(Long id, String name, Double price, String companyName) {
        return null;
    }

    public void deleteProduct(Long id) {

    }
}
