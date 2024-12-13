package com.example.utilisateur.repositories;
import com.example.utilisateur.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long>  {


}
