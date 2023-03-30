package io.mars.cereal.controller;

import io.mars.cereal.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return null;
    }

    public ResponseEntity<Product> updateProduct(Long id, String name, Double price, String companyName) {
        return null;
    }

    public void deleteProduct(Long id) {

    }
}
