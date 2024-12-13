package com.example.utilisateur.services;


import com.example.utilisateur.entities.User;
import com.example.utilisateur.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

}
