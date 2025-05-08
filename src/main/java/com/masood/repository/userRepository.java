package com.masood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masood.model.User;

public interface userRepository extends JpaRepository<User, Long> 
{

}
