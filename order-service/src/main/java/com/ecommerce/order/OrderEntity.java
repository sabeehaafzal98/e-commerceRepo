package com.ecommerce.order;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class OrderEntity extends PanacheEntity {
    public String customerId;
    public String productId;
    public int quantity;
    public String status;
}
