package com.proyect.proyect_market.percistence.crud;

import com.proyect.proyect_market.percistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository <Product, Integer> {
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);
    Optional<List<Product>> findByQuantityLessThanAndStatus(int quantity, boolean status);
}
