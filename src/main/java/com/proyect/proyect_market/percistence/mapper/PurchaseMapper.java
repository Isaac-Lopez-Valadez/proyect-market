package com.proyect.proyect_market.percistence.mapper;

import com.proyect.proyect_market.domain.Purchase;
import com.proyect.proyect_market.percistence.entity.Buy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "buyId", target = "purchaseId"),
            @Mapping(source = "customerId", target = "customerId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "products",target = "items")
    })
    Purchase toPurchase(Buy buy);
    List<Purchase> toPurchases(List<Buy> buy);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    Buy toBuy(Purchase purchase);

}
