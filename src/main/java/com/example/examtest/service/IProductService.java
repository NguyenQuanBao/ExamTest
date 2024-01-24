package com.example.examtest.service;

import com.example.examtest.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void remove(Long id);

    void edit(Product product, Long id);
}
