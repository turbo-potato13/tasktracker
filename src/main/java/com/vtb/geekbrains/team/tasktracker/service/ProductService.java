package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Product;
import com.vtb.geekbrains.team.tasktracker.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
