package com.proyect.proyect_market.percistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BuyProductPK implements Serializable {

    @Column(name = "id_compra")
    private Integer buyId;

    @Column(name = "id_producto")
    private Integer productId;

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
