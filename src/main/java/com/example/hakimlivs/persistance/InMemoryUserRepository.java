package com.example.hakimlivs.persistance;

import com.example.hakimlivs.model.User;
import com.example.hakimlivs.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository implements UserRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserRepository.class);
    private final Map<String, User> db = new ConcurrentHashMap<>();

    @Override
    public void save(final User user) {
        db.put(user.getUsername(), user);
    }

    @Override
    public Optional<User> findById(final String userId) {
        LOG.info("Trying to find user {}", userId);
        return Optional.ofNullable(db.get(userId));
    }
}
