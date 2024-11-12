package com.taarobravo.microservices.order.service;

import com.taarobravo.microservices.order.model.Order;
import com.taarobravo.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(Order order){
        orderRepository.save(order);
    }
}
