package com.example.paymentTest.service;

import com.example.paymentTest.domain.Product;
import com.example.paymentTest.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public void addProduct(){
        Product product = new Product();
        product.setPdprice(50000);
        productRepository.save(product);
    }
}
