package com.proyect.proyect_market.percistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class BuyProduct {

    @EmbeddedId
    private BuyProductPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private Integer total;

    @Column(name = "estado")
    private Boolean status;

    public BuyProductPK getId() {
        return id;
    }

    public void setId(BuyProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
