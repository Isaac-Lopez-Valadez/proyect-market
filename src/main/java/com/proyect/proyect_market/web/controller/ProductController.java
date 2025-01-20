package com.proyect.proyect_market.web.controller;

import com.proyect.proyect_market.domain.ProductDomain;
import com.proyect.proyect_market.domain.service.ProductService;
import com.proyect.proyect_market.percistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public List<ProductDomain> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductDomain> getProduct(@PathVariable("id") int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{id}")
    public Optional<List<ProductDomain>> getByCategory(@PathVariable("id") int categoryId) {
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public ProductDomain saveProduct(@RequestBody ProductDomain product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct (@PathVariable("id") int productId) {
        return productService.deleteProduct(productId);
    }

}
