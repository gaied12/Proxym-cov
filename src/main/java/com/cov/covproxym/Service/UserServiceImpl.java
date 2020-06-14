package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private UserService userService ;
    @Autowired
PasswordEncoder passwordEncoder ;
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
User user1=new User() ;
user1.setLastName(user.getLastName());
user1.setDepartement(user.getDepartement());
user1.setName(user.getName());
user1.setPhoneNumber(user.getPhoneNumber());
user1.setPaswword(passwordEncoder.encode(user.getPaswword()));
user1.setUsername(user.getUsername());
user1.setProfession(user.getProfession());



      return   userRepository.save(user1) ;

          }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> users() {
        return userRepository.findAll();
    }


}
