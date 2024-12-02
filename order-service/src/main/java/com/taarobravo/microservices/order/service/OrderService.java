package com.taarobravo.microservices.order.service;

import com.taarobravo.microservices.order.client.InventoryClient;
import com.taarobravo.microservices.order.dto.OrderRequest;
import com.taarobravo.microservices.order.event.OrderPlacedEvent;
import com.taarobravo.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest){
        var order = orderRequest.toModel();
        var hasStockOfProduct = inventoryClient.hasStock(order.getSkuCode(), order.getQuantity());
        if(hasStockOfProduct){

            orderRepository.save(order);

            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent();
            orderPlacedEvent.setOrderNumber(order.getOrderNumber());
            orderPlacedEvent.setEmail(orderRequest.userDetails().email());
            orderPlacedEvent.setFirstName(orderRequest.userDetails().email());
            orderPlacedEvent.setLastName("");
            log.info("Start sending OrderPlacedEvent {} to Kafka topic 'order-placed'", orderPlacedEvent);
            kafkaTemplate.send("order-placed", orderPlacedEvent);
            log.info("End sending OrderPlacedEvent {} to Kafka topic 'order-placed'", orderPlacedEvent);
        }
        else
            throw new RuntimeException("Product with SkuCode: " + order.getSkuCode() + " has not Stock");
    }
}
