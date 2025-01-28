package com.nando.api_rest.controllers;

import com.nando.api_rest.domains.User;
import com.nando.api_rest.dtos.UserRecordDto;
import com.nando.api_rest.repositories.UserRepository;
import com.nando.api_rest.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/app")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<User> createUser (@RequestBody @Valid UserRecordDto userRecordDto){

        var user = new User();
        BeanUtils.copyProperties(userRecordDto, user);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
