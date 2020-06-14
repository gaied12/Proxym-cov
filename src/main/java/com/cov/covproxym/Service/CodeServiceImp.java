package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.CodeRepository;
import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.model.Code;
import com.cov.covproxym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
@Service
public class CodeServiceImp implements CodeService {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private CodeRepository codeRepository ;
    @Override
    public Code saveKey(Long Iduser) {
        Code code=new Code() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Date date=new Date();
        code.setDate(dateFormat.format(date));
        code.setKey((int) Math.floor(Math.random() * 899999 + 100000));
        Optional<User>user=userRepository.findById(Iduser);
        code.setUser(user.get());
        return codeRepository.save(code);


    }
}
