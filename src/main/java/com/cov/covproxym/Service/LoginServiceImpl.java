package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.exception.ApplicationException;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LoginServiceImpl implements  LoginService {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    PasswordEncoder passwordEncoder ;


    @Override
    public User authenticated(LoginDto loginDto) throws Exception {
        Optional<User>userOptional=this.userRepository.findByUserName(loginDto.getUsername());

        if (!userOptional.isPresent() ){
            throw new ApplicationException(" user or password incorect","98");
        }
        User user=userOptional.get();


        String passData=user.getPaswword() ;

        boolean test= passwordEncoder.matches(loginDto.getPassword(),passData);

        if ( test==false ){
            throw new ApplicationException(" user or password incorect","98");
        }


        return user ;



    }
    public boolean matches(long id,String pass){
        Optional<User>userOptional=userRepository.findById(id);
        String passData=userOptional.get().getPaswword() ;
      return   passwordEncoder.matches(pass,passData);

    }

}
