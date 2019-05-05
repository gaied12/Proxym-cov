package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private UserService userService ;


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {

        userRepository.save(user) ;
        return  user;  }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }


}
