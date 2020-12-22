package com.cov.covproxym.Service;

import com.cov.covproxym.Repository.UserRepository;
import com.cov.covproxym.model.User;
import com.cov.covproxym.utils.UserDto;
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
        return userRepository.findByUserName(username);
    }

    @Override
    public User saveUser(UserDto user) {
User user1=new User() ;
user1.setLastName(user.getLastName());
user1.setFirstName(user.getFirstName());
user1.setSexe(user.getSexe());
if (user.getSexe().equals("homme")){
    user1.setImgPath("assets/icon/user_male.png");
}
       else if (user.getSexe().equals("femme")){
    user1.setImgPath("assets/icon/user_female.png");


}
user1.setPhoneNumber(user.getPhoneNumber());
user1.setPaswword(passwordEncoder.encode(user.getPassword()));
user1.setUserName(user.getUserName());
user1.setvMarque(user.getvMarque());



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
