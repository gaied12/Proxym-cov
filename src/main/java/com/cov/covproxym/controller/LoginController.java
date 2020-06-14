package com.cov.covproxym.controller;

import com.cov.covproxym.Service.LoginService;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class LoginController {
@Autowired
LoginService loginService ;
    @RequestMapping(method = RequestMethod.POST,value = "/auth")
    public User auth(@RequestBody LoginDto loginDto) throws Exception{
        return loginService.authenticated(loginDto);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/testpass")
    public boolean auth(@RequestParam long  id ,@RequestParam String pass) throws Exception{
        return loginService.matches(id,pass);
    }
}
