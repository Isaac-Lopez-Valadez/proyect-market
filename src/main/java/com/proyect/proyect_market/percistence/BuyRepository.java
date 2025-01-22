package com.proyect.proyect_market.percistence;

import com.proyect.proyect_market.domain.Purchase;
import com.proyect.proyect_market.domain.repository.PurchaseRepository;
import com.proyect.proyect_market.percistence.crud.BuyCrudRepository;
import com.proyect.proyect_market.percistence.entity.Buy;
import com.proyect.proyect_market.percistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BuyRepository implements PurchaseRepository {
    @Autowired
    private BuyCrudRepository buyCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Buy>) buyCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByCustomer(String customerId) {
        return buyCrudRepository.findByCustomerId(customerId)
                .map(buy -> mapper.toPurchases(buy));
    }

    @Override
    public Purchase save(Purchase purchase) {
       Buy buy = mapper.toBuy(purchase);
       buy.getProducts().forEach(product -> product.setBuy(buy));
       return mapper.toPurchase( buyCrudRepository.save(buy));
    }
}
