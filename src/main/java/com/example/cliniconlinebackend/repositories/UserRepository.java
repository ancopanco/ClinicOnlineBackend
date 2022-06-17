package com.example.cliniconlinebackend.repositories;

import com.example.cliniconlinebackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
}
