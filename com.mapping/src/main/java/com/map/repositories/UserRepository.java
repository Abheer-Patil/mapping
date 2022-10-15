package com.map.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.map.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
