package com.example.hakimlivs.repository;

/**
 * Created by Jesper Friberg Spång
 * Date: 2021-09-06
 * Time: 15:01
 * Project: hakimlivs
 * Copyright: MIT
 */
import com.example.hakimlivs.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(final User user);

    Optional<User> findById(final String userName);
}
