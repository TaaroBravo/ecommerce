package com.taarobravo.microservices.order.service;

import com.taarobravo.microservices.order.client.InventoryClient;
import com.taarobravo.microservices.order.model.Order;
import com.taarobravo.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(Order order){
        var hasStockOfProduct = inventoryClient.hasStock(order.getSkuCode(), order.getQuantity());
        if(hasStockOfProduct)
            orderRepository.save(order);
        else
            throw new RuntimeException("Product with SkuCode: " + order.getSkuCode() + " has not Stock");
    }
}
