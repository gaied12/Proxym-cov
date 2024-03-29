package com.cov.covproxym.controller;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.Service.LoginService;
import com.cov.covproxym.Service.UserService;
import com.cov.covproxym.model.PublicationTrajet;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)

public class UserController {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private UserService userService ;

@RequestMapping(value = "/add/user",method = RequestMethod.POST)
    public User save( @RequestBody UserDto user) {

    return userService.saveUser(user);
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> ShowUser(@PathVariable long id) {

    return userService.findById(id);
    }

@RequestMapping(value = "/user/all", method = RequestMethod.GET)
public List<User> ShowUsers(){
    return  userRepository.findAll() ;
}



}


