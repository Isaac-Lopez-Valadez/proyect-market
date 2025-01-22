package com.proyect.proyect_market.web.controller;

import com.proyect.proyect_market.domain.Purchase;
import com.proyect.proyect_market.domain.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchases")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll () {
        return new ResponseEntity<>(buyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Purchase>> getByCustomer (@PathVariable("id") String customerId) {
        return buyService.getByCustomer(customerId)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }

    @PostMapping()
    public ResponseEntity<Purchase> save (@RequestBody Purchase purchase) {
        return new ResponseEntity<>(buyService.save(purchase), HttpStatus.CREATED);
    }

}
