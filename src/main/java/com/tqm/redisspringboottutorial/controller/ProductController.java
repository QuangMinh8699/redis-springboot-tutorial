package com.tqm.redisspringboottutorial.controller;

import com.tqm.redisspringboottutorial.entity.Product;
import com.tqm.redisspringboottutorial.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable Long id) {
        return productRepo.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id) {
        return productRepo.deleteProduct(id);
    }
}
