package com.proyect.proyect_market.percistence;

import com.proyect.proyect_market.domain.ProductDomain;
import com.proyect.proyect_market.domain.repository.ProductDomainRepository;
import com.proyect.proyect_market.percistence.crud.ProductCrudRepository;
import com.proyect.proyect_market.percistence.entity.Product;
import com.proyect.proyect_market.percistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductDomainRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDomain> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDomain(products);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        List<Product> products = (List<Product>) productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDomain(products));
    }
    @Override
    public Optional<List<ProductDomain>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByQuantityLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProductsDomain(prods));
    }

    @Override
    public Optional<ProductDomain> getProduct (int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProductDomain(product));
    }

    @Override
    public ProductDomain saveProduct(ProductDomain productDomain) {
        Product product = mapper.toProduct(productDomain);
        System.out.println("Producto antes de guardar: " + product);
        return mapper.toProductDomain(productCrudRepository.save(product));
    }

    @Override
    public void deleteProduct(int productId){
        productCrudRepository.deleteById(productId);
    }
}
