package com.proyect.proyect_market.domain.service;

import com.proyect.proyect_market.domain.Purchase;
import com.proyect.proyect_market.percistence.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyService {

    @Autowired
    private BuyRepository buyRepository;

    public List<Purchase> getAll () {
        return buyRepository.getAll();
    }

    public Optional<List<Purchase>> getByCustomer (String customerId) {
        return buyRepository.getByCustomer(customerId);
    }

    public Purchase save(Purchase purchase) {
        return buyRepository.save(purchase);
    }
}
