package com.proyect.proyect_market.percistence;

import com.proyect.proyect_market.percistence.crud.ProductCrudRepository;
import com.proyect.proyect_market.percistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategoria) {
        return (List<Product>) productCrudRepository.findByCategoryIdOrderByNameAsc(idCategoria);
    }

    public Optional<List<Product>> getScarce(int quantity) {
        return productCrudRepository.findByQuantityLessThanAndStatus(quantity, true);
    }
}
