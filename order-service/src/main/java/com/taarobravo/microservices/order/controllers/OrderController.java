package com.taarobravo.microservices.order.controllers;

import com.taarobravo.microservices.order.dto.OrderRequest;
import com.taarobravo.microservices.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderServiceController {

    private final OrderService orderService;

    @PostMapping
    public void placeOrder(@RequestBody OrderRequest request){
        orderService.placeOrder(request.toModel());
    }
}
