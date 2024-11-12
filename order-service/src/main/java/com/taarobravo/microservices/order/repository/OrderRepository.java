package com.taarobravo.microservices.order.repository;

import com.taarobravo.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
