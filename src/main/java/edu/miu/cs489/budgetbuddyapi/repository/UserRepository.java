package edu.miu.cs489.budgetbuddyapi.repository;

import edu.miu.cs489.budgetbuddyapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
