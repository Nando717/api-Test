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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/users")
    public ResponseEntity<List<User>> findA (User user){

        return ResponseEntity.status(HttpStatus.OK).body(userService.findAlll(user));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> findId (@PathVariable(name = "id")UUID id){

        Optional<User> usEr = userRepository.findById(id);

        if (usEr.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));

    }


    @PutMapping("/user/{id}")
    public ResponseEntity<Object> upUser (@PathVariable(name = "id") UUID id,
                                          @RequestBody @Valid UserRecordDto userRecordDto){

        Optional<User> usER = userRepository.findById(id);

        if (usER.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");
        }
        var user = usER.get();

        BeanUtils.copyProperties(userRecordDto, user);

        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUsers (@PathVariable(name = "id") UUID id){

        Optional<User> usER = userRepository.findById(id);

        if (usER.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario não encontrado");

        }

        userRepository.delete(usER.get());
        return ResponseEntity.status(HttpStatus.OK).body("usuario deletado");
    }


}
