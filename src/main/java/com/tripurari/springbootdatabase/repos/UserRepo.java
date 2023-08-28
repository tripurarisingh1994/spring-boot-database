package com.tripurari.springbootdatabase.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tripurari.springbootdatabase.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
