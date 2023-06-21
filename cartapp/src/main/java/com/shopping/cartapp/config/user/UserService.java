package com.shopping.cartapp.config.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public  List<User> getallUsers(){
        return  userRepository.findAll();
    }

    public Optional<User> getUserByEmail(String email){
        return  userRepository.findByEmail(email);
    }

    private Optional<User> getUserByPhone(String phone){
        return  userRepository.findByPhone(phone);
    }
}
