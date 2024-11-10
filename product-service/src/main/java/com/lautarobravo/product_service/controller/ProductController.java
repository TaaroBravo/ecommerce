package com.lautarobravo.product_service.controller;

import com.lautarobravo.product_service.dtos.ProductRequest;
import com.lautarobravo.product_service.dtos.ProductResponse;
import com.lautarobravo.product_service.model.Product;
import com.lautarobravo.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        return ProductResponse.from(productService.createProduct(request.toModel()));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts()
                .stream().map(ProductResponse::from)
                .toList();
    }
}
