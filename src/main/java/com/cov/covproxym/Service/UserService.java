package com.cov.covproxym.Service;

import com.cov.covproxym.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User>findByUsername(String username);
    public User saveUser(User user);
    Optional<User> findById(long id);


}
