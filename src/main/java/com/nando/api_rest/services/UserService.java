package com.nando.api_rest.services;


import com.nando.api_rest.domains.User;
import com.nando.api_rest.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @Transactional
    public User save (User user){
        return userRepository.save(user);
    }

    @Transactional
    public List<User> findAlll(User user){
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> findById (UUID id){
        return userRepository.findById(id);
    }


    @Transactional
    public User apdateUser (UUID id, User user){
       userRepository.findById(id);
        return userRepository.save(user);
    }


    @Transactional
    public User findName (User user){
        return userRepository.findByName();
    }



}
