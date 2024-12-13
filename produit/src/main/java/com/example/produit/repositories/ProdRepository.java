package com.example.produit.repositories;

import com.example.produit.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdRepository extends JpaRepository<Product, Long> {

}
