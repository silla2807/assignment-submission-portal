package com.growthx.assignmentportal.repository;

import com.growthx.assignmentportal.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserId(String userId);
    boolean existsByUserId(String userId);
    List<User> findByRole(String admin);
}
