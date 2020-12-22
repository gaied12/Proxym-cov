package com.cov.covproxym.Service;

import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User>findByUsername(String username);
    public User saveUser(UserDto user);
    Optional<User> findById(long id);
    List<User> users();


}
