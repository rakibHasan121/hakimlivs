package com.example.hakimlivs.persistance;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-09-06
 * Time: 15:01
 * Project: hakimlivs
 * Copyright: MIT
 */
import com.example.hakimlivs.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findUserById(Long id);
    User findUserByUsername(String username);
}
