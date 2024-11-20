package com.taarobravo.microservices.order.dto;

import com.taarobravo.microservices.order.model.Order;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderRequest(Long id, String orderNumber, String skuCode, BigDecimal price, Integer quantity, UserDetails userDetails) {
    public Order toModel() {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(price);
        order.setSkuCode(skuCode);
        order.setQuantity(quantity);
        return order;
    }

    public record UserDetails(String email, String firstName, String lastName){}
}
