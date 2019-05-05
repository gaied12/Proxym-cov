package com.cov.covproxym.Service;

import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.LoginDto;

import java.util.List;
import java.util.Optional;

public interface LoginService {
public Optional<User> authenticated (LoginDto loginDto) throws Exception;
public List<String> getAllPersonNames() ;
public List<String>gellAllPassword();
}
