package dev.jatin.produtservice.service;

import dev.jatin.produtservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
    Product createProduct(String title,
                          String description,
                          double price,
                          String category,
                          String image
    );
}
