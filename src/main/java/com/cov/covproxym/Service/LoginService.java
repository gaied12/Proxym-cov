package com.cov.covproxym.Service;

import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.LoginDto;

public interface LoginService {
public User authenticated (LoginDto loginDto) throws Exception;
    public boolean matches(long id,String pass);

}
