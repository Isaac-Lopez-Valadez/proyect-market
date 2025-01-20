package com.proyect.proyect_market.domain.service;

import com.proyect.proyect_market.domain.ProductDomain;
import com.proyect.proyect_market.percistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDomain> getAll () {
        return productRepository.getAll();
    }

    public Optional<ProductDomain> getProduct (int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public ProductDomain saveProduct (ProductDomain product) {
        return productRepository.saveProduct(product);
    }

    public boolean deleteProduct (int productId) {
        return getProduct(productId).map(product -> {
            productRepository.deleteProduct(productId);
            return true;
        }).orElse(false);

    }
}
