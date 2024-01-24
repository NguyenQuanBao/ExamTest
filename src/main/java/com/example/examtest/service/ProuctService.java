package com.example.examtest.service;

import com.example.examtest.model.Product;
import com.example.examtest.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProuctService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;


    @Override
    public Optional<Product> findById(Long id){
        return iProductRepository.findById(id);
    }
    @Override
    public Iterable<Product> findAll(){
        return iProductRepository.findAll();
    }
    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void edit(Product product, Long id){
        product.setId(id);
        iProductRepository.save(product);
    }
}
