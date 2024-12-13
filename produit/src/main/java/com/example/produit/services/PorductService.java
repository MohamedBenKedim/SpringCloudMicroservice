package com.example.produit.services;
import com.example.produit.repositories.ProdRepository;

import com.example.produit.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PorductService {

    final ProdRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


}
