package com.nando.api_rest.services;


import com.nando.api_rest.domains.User;
import com.nando.api_rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @Transactional
    public User save (User user){
        return userRepository.save(user);
    }
}
