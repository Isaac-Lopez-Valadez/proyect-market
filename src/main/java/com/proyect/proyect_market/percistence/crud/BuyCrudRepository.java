package com.proyect.proyect_market.percistence.crud;

import com.proyect.proyect_market.percistence.entity.Buy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuyCrudRepository extends CrudRepository<Buy, Integer> {

    Optional<List<Buy>> findByCustomerId(String customerId);
}
