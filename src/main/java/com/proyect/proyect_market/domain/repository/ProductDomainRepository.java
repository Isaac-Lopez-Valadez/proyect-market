package com.proyect.proyect_market.domain.repository;

import com.proyect.proyect_market.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {
    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryId);
    Optional<List<ProductDomain>> getScarseProducts(int quantity);
    Optional<ProductDomain> getProduct(int productId);
    ProductDomain saveProduct(ProductDomain product);
    void deleteProduct(int productId);
}
