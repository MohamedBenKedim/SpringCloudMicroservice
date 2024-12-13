package com.example.produit.controllers;

import com.example.produit.DTO.UserDto;
import com.example.produit.services.PorductService;
import com.example.produit.entities.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class productsController {

    final PorductService porductService;
    private final RestTemplate restTemplate;
    private static final String USER_MICROSERVICE_URL = "http://192.168.78.212:8084/users";

    @GetMapping
    public List<Product> products() {
        return porductService.getAllProducts();
    }

    @GetMapping("/allprods")

    public List<Product> getProducts() {
        return porductService.getAllProducts();
    }

    @CircuitBreaker(name = "productmicroService", fallbackMethod = "fallback")
    @GetMapping("/users")
    public List<UserDto> getUsersFromUserMicroservice() {
        // Make an HTTP GET request to the user microservice
        ResponseEntity<List<UserDto>> response = restTemplate.exchange(
                USER_MICROSERVICE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        return response.getBody(); // Return the list of users
    }
   /* The fallback method must have the same return type (List<UserDto>) as the method it's backing up (getUsersFromUserMicroservice()).
    It should also accept an Exception or a specific exception type as a parameter (matching the exception type that could be thrown in the original method). */
    public List<UserDto> fallback(Exception e) {
        System.out.println("********** ERRORS OCCURRING !!!! ************");
        // Return a default or empty list when the service call fails
        return Collections.emptyList(); // Or some fallback data
    }
}
