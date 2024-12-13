package com.example.utilisateur.controllers;


import com.example.utilisateur.entities.User;
import com.example.utilisateur.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class utilisateur {

    private final UserService userService;

    @GetMapping
    List<User> getUsers()
    {
        return userService.getAllUsers();
    }

}
