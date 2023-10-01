package com.example.springboot.service.impl;

import com.example.springboot.entity.Product;
import com.example.springboot.repository.ProductRepository;
import com.example.springboot.service.ProductService;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
