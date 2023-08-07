package com.sharad.ridersspot.repository;

import com.sharad.ridersspot.collection.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
        Boolean existsByEmail(String email);
        Optional<User> findByEmail(String username);
}
