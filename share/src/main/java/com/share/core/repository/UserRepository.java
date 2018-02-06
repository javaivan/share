package com.share.core.repository;

import com.share.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findById(String userId);
    User findByEmail(String email);
}