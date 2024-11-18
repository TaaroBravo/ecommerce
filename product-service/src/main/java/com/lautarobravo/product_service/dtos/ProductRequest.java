package com.lautarobravo.product_service.dtos;


import com.lautarobravo.product_service.model.Product;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, String skuCode, BigDecimal price) {

    public Product toModel(){
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .skuCode(skuCode)
                .price(price)
                .build();
    }
}
