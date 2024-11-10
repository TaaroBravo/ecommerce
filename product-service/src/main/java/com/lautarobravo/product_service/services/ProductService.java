package com.lautarobravo.product_service.services;

import com.lautarobravo.product_service.model.Product;
import com.lautarobravo.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product){
        productRepository.save(product);
        log.info("Product created successfully");
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
