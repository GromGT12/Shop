package com.pl.shop.repository;

import com.pl.shop.shop.database.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    User findFirstByName(String name);
}
