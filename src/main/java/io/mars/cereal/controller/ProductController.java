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

    @PostMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return null;
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable  Long id) {

    }
}
