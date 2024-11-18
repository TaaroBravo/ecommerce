package com.lautarobravo.product_service.dtos;


import com.lautarobravo.product_service.model.Product;

import java.math.BigDecimal;

public record ProductResponse(String id, String name, String description, String skuCode, BigDecimal price) {

    public static ProductResponse from(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getSkuCode(), product.getPrice());
    }
}
