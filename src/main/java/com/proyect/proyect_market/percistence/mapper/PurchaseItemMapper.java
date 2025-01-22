package com.proyect.proyect_market.percistence.mapper;

import com.proyect.proyect_market.domain.PurchaseItem;
import com.proyect.proyect_market.percistence.entity.BuyProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "status", target = "status"),

    })
    PurchaseItem toPurchaseItem(BuyProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.buyId", ignore = true),
            @Mapping(target = "buy", ignore = true),
            @Mapping(target = "product", ignore = true)
    })
    BuyProduct toBuyProduct(PurchaseItem purchaseItem);

}
