package edu.miu.cs489.budgetbuddyapi.service;

import edu.miu.cs489.budgetbuddyapi.exception.EntityAlreadyExistException;
import edu.miu.cs489.budgetbuddyapi.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User addNewUser(User user) throws EntityAlreadyExistException;
    User findByEmail(String email) throws EntityNotFoundException;
}
